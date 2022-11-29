import { Component } from '@angular/core';
import { HttpCallerService } from './http-caller.service';
import { Phone } from './phone';
import { resp } from './response';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private _httpcaller:HttpCallerService){}

  ngOnInit(){
    this.allb=true;
    this._httpcaller.getAll().subscribe((data:resp) =>this.items=data.data);
  }

  title = 'mobile-store';

  public disp="All";
  public all="All";
  
  public apple="Apple";
  public appleimg="https://cdn1.smartprix.com/rx-iwSFqxBrV-w420-h420/apple-iphone-14-pro.jpg";
  public realme="Realme";
  public realmeimg="https://image01.realme.net/general/20220912/1662959333129.png.webp";
  public redmi="Redmi";
  public redmiimg="https://m.media-amazon.com/images/I/81W6rHmWHhL._SX569_.jpg";
  public flagship="https://media.istockphoto.com/id/1052364854/vector/flag.jpg?s=612x612&w=0&k=20&c=oOWMBthXuDuDeax9CLcsyhb6PUa7gXZaizfjvqqVchk=";
  public oneplus="One Plus";
  public oneplusimg="https://m.media-amazon.com/images/I/413u56t+CiL._SY300_SX300_.jpg";
  public samsung="Samsung";
  public samsungimg="https://images.samsung.com/is/image/samsung/p6pim/in/sm-m536bzbeinu/gallery/in-galaxy-m53-5g-sm-m536-sm-m536bzbeinu-532180211?$1300_1038_PNG$";

  mainfun(){
    if(this.allb){
      this._httpcaller.getmain("All",this.toggle,this.priceInput).subscribe((data:resp) => this.items=data.data);
    }
    else if(this.appleb){
      this._httpcaller.getmain("Apple",this.toggle,this.priceInput).subscribe((data:resp) => this.items=data.data);
    }
    else if(this.realmeb){
      this._httpcaller.getmain("Realme",this.toggle,this.priceInput).subscribe((data:resp) => this.items=data.data);
    }
    else if(this.redmib){
      this._httpcaller.getmain("Redmi",this.toggle,this.priceInput).subscribe((data:resp) => this.items=data.data);
    }
    else if(this.oneplusb){
      this._httpcaller.getmain("One plus",this.toggle,this.priceInput).subscribe((data:resp) => this.items=data.data);
    }
    else if(this.samsungb){
      this._httpcaller.getmain("Samsung",this.toggle,this.priceInput).subscribe((data:resp) => this.items=data.data);
    }
  }

  public allb:boolean=false;
  public appleb:boolean=false;
  public realmeb:boolean=false;
  public redmib:boolean=false;
  public oneplusb:boolean=false;
  public samsungb:boolean=false;
  menufun(){
    this.allb=false;
    this.appleb=false;
    this.realmeb=false;
    this.redmib=false;
    this.oneplusb=false;
    this.samsungb=false;
  }

  public toggle:boolean=false;
  public priceInput:any;

  public items:Phone[]=[];
}
