package com.bus.smartbus

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.bus.smartbus.BusDB

val DATABASE_NAME ="MyDB"
val TABLE_BUS="bus"
val TABLE_STATION="stations"
val TABLE_ROUTE="route"
val TABLE_SHEDULE="shedule"

val COL_BUS_ID = "id"
val COL_BUS_NAME = "name"
val COL_BUS_DESCRIPTION = "description"
val COL_BUS_ROUTECOORD = "routeCoord"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTableBus = "CREATE TABLE bus (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                " name TEXT," +
                " description TEXT," +
                " routeCoord  TEXT)"

        val createTableRoute = "CREATE TABLE route (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "stoptime TEXT," +
                "stationid INT REFERENCES stations (id)," +
                "busid INT REFERENCES bus (id))"

        val createTableStation = "CREATE TABLE stations (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "locationcoord TEXT)"

        val createTableShedule = "CREATE TABLE shedule (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "busid INT REFERENCES bus (id)," +
                "stationid INT REFERENCES stations (id)," +
                "time TEXT)"

        db?.execSQL(createTableBus)
        db?.execSQL(createTableRoute)
        db?.execSQL(createTableStation)
        db?.execSQL(createTableShedule)

    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(bus : BusDB){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_BUS_NAME,bus.name)
        cv.put(COL_BUS_DESCRIPTION,bus.description)
        cv.put(COL_BUS_ROUTECOORD,bus.routeCoord)
        var result = db.insert(TABLE_BUS,null,cv)
        if(result == (-1).toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }


    fun readData() : MutableList<BusDB>{
        var list : MutableList<BusDB> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_BUS
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var bus = BusDB()
                bus.id = result.getInt(result.getColumnIndex(COL_BUS_ID))
                bus.name = result.getString(result.getColumnIndex(COL_BUS_NAME))
                bus.description = result.getString(result.getColumnIndex(COL_BUS_DESCRIPTION))
                bus.routeCoord = result.getString(result.getColumnIndex(COL_BUS_ROUTECOORD))
                list.add(bus)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_BUS,null,null)
        db.delete(TABLE_STATION,null,null)
        db.delete(TABLE_SHEDULE,null,null)
        db.delete(TABLE_ROUTE,null,null)
        db.close()
    }

    fun resetAuto(){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_BUS + "'")
        db.close()
    }
}