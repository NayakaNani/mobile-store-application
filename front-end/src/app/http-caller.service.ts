import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs';
import { resp } from './response';

@Injectable({
  providedIn: 'root'
})
export class HttpCallerService { 

  constructor(private http:HttpClient) { }

  getAll():Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles/all",{observe:'body',responseType:'json'});
  }

  getFlagship():Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles/flagship",{observe:'body',responseType:'json'});
  }

  getBudjet(prices:number):Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles/budjet",{params:{'a':prices},observe:'body',responseType:'json'});
  }

  getBudjetFlagship(prices:number):Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles/bandf",{params:{'a':prices},observe:'body',responseType:'json'});
  }

  getSpecific(names:string):Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles2/brand",{params:{'name':names},observe:'body',responseType:'json'});
  }

  getSpecificFlag(names:string):Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles2/bandf",{params:{'name':names},observe:'body',responseType:'json'});
  }

  getSpecificBudjet(names:string,a:number):Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles2/bandb",{params:{'name':names,'a':a},observe:'body',responseType:'json'});
  }

  getSpecificFlagshipBudjet(names:string,a:number):Observable<resp>{
    return this.http.get<resp>("http://localhost:8080/mobiles2/bandfandb",{params:{'name':names,'a':a},observe:'body',responseType:'json'});
  }

  getmain(names:string,flag:boolean,prices:number):Observable<resp>{
    if(names=="All"){
      if(!flag&&((prices)==0||(prices)<1||(prices)==null)){
        return this.getAll();
      }
      else if(!flag&&((prices)>0)) {
        return this.getBudjet(prices);
      }
      else if(flag&&((prices)==0||(prices)<1||(prices)==null)){
        return this.getFlagship();
      }
      else if(flag&&((prices)>0)){
        return this.getBudjetFlagship(prices);
      }
    }
    else{
      if(!flag&&((prices)==0||(prices)<1||(prices)==null)){
        return this.getSpecific(names);
      }
      else if(!flag&&((prices)>0)){
        return this.getSpecificBudjet(names,prices);
      }
      else if(flag&&((prices)==0||(prices)<1||(prices)==null)){
        return this.getSpecificFlag(names);
      }
      else if(flag&&((prices)>0)){
        return this.getSpecificFlagshipBudjet(names,prices);
      }
    }
    return this.getAll();
  }
}
