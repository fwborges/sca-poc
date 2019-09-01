import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-monitoramento',
  templateUrl: './monitoramento.component.html',
  styleUrls: ['./monitoramento.component.css']
})
export class MonitoramentoComponent implements OnInit {
  public chartType = 'line';

  numero = 5;

  public chartDatasets: Array<any> = [
    { data: [5,50,10,7,20,25], label: 'Barragem 1' },
    { data: [2,4,6,65,2,34,32,65], label: 'Barragem 2' }
  ];

  public chartLabels: Array<any> = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  public chartColors: Array<any> = [
    {
      backgroundColor: 'rgba(105, 0, 132, .2)',
      borderColor: 'rgba(200, 99, 132, .7)',
      borderWidth: 2,
    },
    {
      backgroundColor: 'rgba(0, 137, 132, .2)',
      borderColor: 'rgba(0, 10, 130, .7)',
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };

  constructor() { }

  

  ngOnInit() {
    console.log(this.numero++);
    this.chartDatasets[0].data.push(this.numero++);
    console.log(this.chartDatasets[0].data);
    this.lerSensores();
  }

  lerSensores() {

    setInterval(function() {
     
      this.chartDatasets = [
        { data: Array.from({length: 40}, () => Math.floor(Math.random() * 40)), label: 'Barragem 1' },
        { data: Array.from({length: 40}, () => Math.floor(Math.random() * 40)), label: 'Barragem 2' }
      ];
    }, 5000);
  }

  

  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }
}
