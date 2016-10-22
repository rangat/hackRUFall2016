package tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.culinera.culinera.R;
import com.robotpajamas.blueteeth.BlueteethDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arjun Bansil on 10/22/2016.
 */

public class DeviceScanListAdapter extends BaseAdapter {
    private final LayoutInflater mLayoutInflater;
    private List<BlueteethDevice> mDevices;

    public DeviceScanListAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
        mDevices = new ArrayList<>();
    }

    @Override
    public int getCount(){
        return mDevices.size();
    }

    @Override
    public BlueteethDevice getItem(int position){
        return mDevices.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        DeviceHolder holder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.listitem_device_scan, parent, false);
            holder = new DeviceHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (DeviceHolder)convertView.getTag();
        }
        return convertView;
    }

    public void clear() {
        mDevices.clear();
        notifyDataSetChanged();
    }


    public void add(BlueteethDevice device){
        boolean isAlreadyInList = false;
        for(BlueteethDevice d:  mDevices){
            if(device.getMacAddress().equals((d.getMacAddress()))){
                isAlreadyInList = true;
                break;
            }
        }
        if(!isAlreadyInList){
            mDevices.add(device);
            notifyDataSetChanged();
        }
    }

    public static class DeviceHolder{
        TextView deviceName;
        TextView deviceMac;
        public DeviceHolder(View view){
            deviceName = (TextView)view.findViewById(R.id.textview_device_name);
            deviceMac = (TextView)view.findViewById(R.id.textview_device_mac);
        }
    }
}
