package com.bus.smartbus

class StationDB{

    var id : Int = 0
    var name : String = ""
    var locationcoord : String = ""

    constructor(name:String,locationcoord:String){
        this.name = name
        this.locationcoord = locationcoord
    }

    constructor(){
    }

}