package com.bus.smartbus

class SheduleDB{

    var id : Int = 0
    var busId : Int = 0
    var stationId : Int = 0
    var time : String = ""

    constructor(busId:Int, stationId:Int, time:String){
        this.busId = busId
        this.stationId = stationId
        this.time = time
    }

    constructor(){

    }

}