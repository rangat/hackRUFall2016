var ctx = document.getElementById("myChart1").getContext("2d");
var ctx2 = document.getElementById("myChart2").getContext("2d");
var ctx3 = document.getElementById("myChart3").getContext("2d");
var ctx4 = document.getElementById("myChart4").getContext("2d");
var ctx5 = document.getElementById("myChart5").getContext("2d");
var ctx6 = document.getElementById("myChart6").getContext("2d");
var ctx7 = document.getElementById("myChart7").getContext("2d");


// var myChart = new Chart(ctx, {
//     type: 'bar',
//     data: {
//         labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
//         datasets: [{
//             label: '# of Votes',
//             data: [12, 19, 3, 5, 2, 3],
//             backgroundColor: [
//                 'rgba(255, 99, 132, 0.2)',
//                 'rgba(54, 162, 235, 0.2)',
//                 'rgba(255, 206, 86, 0.2)',
//                 'rgba(75, 192, 192, 0.2)',
//                 'rgba(153, 102, 255, 0.2)',
//                 'rgba(255, 159, 64, 0.2)'
//             ],
//             borderColor: [
//                 'rgba(255,99,132,1)',
//                 'rgba(54, 162, 235, 1)',
//                 'rgba(255, 206, 86, 1)',
//                 'rgba(75, 192, 192, 1)',
//                 'rgba(153, 102, 255, 1)',
//                 'rgba(255, 159, 64, 1)'
//             ],
//             borderWidth: 1
//         }]
//     },
//     options: {
//         scales: {
//             yAxes: [{
//                 ticks: {
//                     beginAtZero:true
//                 }
//             }]
//         }
//     }
// });
var data = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [34, 66],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};

var data2 = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [27, 73],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};

var data3 = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [93, 7],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};

var data4 = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [70, 30],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};
var data5 = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [4, 96],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};
var data6 = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [20, 80],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};
var data7 = {
    labels: [
        "Yes",
        "NO"
    ],
    datasets: [
        {
            data: [3, 97],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",

            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }]
};

var myChart1 = new Chart(ctx,{
    type:"pie",
    data:data,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});

var myChart2 = new Chart(ctx2,{
    type:"pie",
    data:data2,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});

var myChart3 = new Chart(ctx3,{
    type:"pie",
    data:data3,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});



var myChart4 = new Chart(ctx4,{
    type:"pie",
    data:data4,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});


var myChart5 = new Chart(ctx5,{
    type:"pie",
    data:data5,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});


var myChart6 = new Chart(ctx6,{
    type:"pie",
    data:data6,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});


var myChart7 = new Chart(ctx7,{
    type:"pie",
    data:data7,
    options: {
        elements: {
            points: {
                borderWidth: 1,
                borderColor: 'rgb(0, 0, 0)'
            }
        }
    }
});




