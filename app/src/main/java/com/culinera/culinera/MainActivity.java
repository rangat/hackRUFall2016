package com.culinera.culinera;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.robotpajamas.blueteeth.BlueteethDevice;
import com.robotpajamas.blueteeth.BlueteethManager;

import java.util.ArrayList;

import tools.DeviceScanListAdapter;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swp;
    private static final int REQ_BLUETOOTH_ENABLE = 1000;
    private static final int DEVICE_SCAN_MILLISECONDS = 100private DeviceScanListAdapter mDeviceAdapter;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dexter.initialize(getApplicationContext());
        MultiplePermissionsListener dl =
                DialogOnAnyDeniedMultiplePermissionsListener.Builder
                    .withContext(getApplicationContext())
                    .withTitle("Bluetooth & file storage permission")
                    .withMessage("Both bluetooth and file storage are necessary for the application to work")
                    .withButtonText("Re-do")
                    .withIcon(R.mipmap.ic_launcher)
                    .build();
         Dexter.checkPermissions(dl, Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.READ_EXTERNAL_STORAGE,
                 Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        swp = (SwipeRefreshLayout)findViewById(R.id.swiperefresh);
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(BluetoothDevice.ACTION_FOUND.equals(action)){
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    Log.i("Cancer", "Device: " + device.getName());
                }
                Log.i("Cancer", "Nothing was scanned");
            }
        };
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        Log.i("TAG", "About to scan");
        registerReceiver(mReceiver, filter);
        /*

        checkBluetoothSupport();

        swp.setOnRefreshListener(this::startScanning);
        mDeviceAdapter = new DeviceScanListAdapter(this);
        ListView l = (ListView)findViewById(R.id.bluetoothList);
        l.setAdapter(mDeviceAdapter);
        */
    }

    @Override
    protected void onResume(){
        super.onResume();
//        mDeviceAdapter.clear();
        swp.setRefreshing(true);
        startScanning();
    }

    @Override
    protected void onPause(){
        super.onPause();
        stopScanning();
    }

    private void startScanning(){
        Log.i("Blueteeth", "Start scanning");
      //  mDeviceAdapter.clear();
        BlueteethManager.with(this).scanForPeripherals(DEVICE_SCAN_MILLISECONDS, bledevices -> {
            Log.i("Blueteeth", "Scan completed");
            swp.setRefreshing(false);
            for(BlueteethDevice device :bledevices){
                if(!TextUtils.isEmpty(device.getBluetoothDevice().getName())){
                    Log.i("Blueteeth", device.getName() + " "+ device.getMacAddress());
                    mDeviceAdapter.add(device);
                }
            }
        });
    }

    private void stopScanning(){
        swp.setRefreshing(false);
        BlueteethManager.with(this).stopScanForPeripherals();
    }

    private void checkBluetoothSupport(){
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)){
            Log.e("Error","No bluetooth support");
        }
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if(btAdapter == null){
            Log.e("Error", "No BLE support");
        }
        if(!btAdapter.isEnabled()){
            enableBluetooth();
        }
    }

    @Override
    protected  void onDestroy(){
        unregisterReceiver(mReceiver);
    }

    private void enableBluetooth(){
        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQ_BLUETOOTH_ENABLE);
    }


}
