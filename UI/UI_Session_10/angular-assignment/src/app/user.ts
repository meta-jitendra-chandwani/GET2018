export class User {
  id: number;
  name: string;
  mobile: string;
  location: string;
  constructor(name,mobile,location){
    this.name=name;
    this.mobile=mobile;
    this.location=location
  }
}