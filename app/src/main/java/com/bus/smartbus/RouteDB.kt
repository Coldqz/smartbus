package com.bus.smartbus

class RouteDB{

    var id : Int = 0
    var stationName : String = ""
    var stationId : Int = 0
    var busId : Int = 0

    constructor(stationName:String, stationId:Int, busId:Int){
        this.stationName = stationName
        this.stationId = stationId
        this.busId = busId
    }

    constructor(){

    }

}