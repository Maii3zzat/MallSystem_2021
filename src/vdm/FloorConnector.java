/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdm;

/**
 *
 * @author a_h_s
 */
public class FloorConnector {
    private int id;
    private transportation type;
    private int  MaxCapacity;
    private int currVisitors;
    private boolean  areaOpen;
    private WariningType  isWarned;
    private VDMSequence RequestQ;

    public FloorConnector(int id, transportation type, int MaxCapacity, int currVisitors, boolean areaOpen, WariningType isWarned, VDMSequence RequestQ) {
        this.id = id;
        this.type = type;
        this.MaxCapacity = MaxCapacity;
        this.currVisitors = currVisitors;
        this.areaOpen = areaOpen;
        this.isWarned = isWarned;
        this.RequestQ = RequestQ;
    }
    
    
    
    //RequestQ: seq of Customer

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public transportation getType() {
        return type;
    }

    public void setType(transportation type) {
        this.type = type;
    }

    public int getMaxCapacity() {
        return MaxCapacity;
    }

    public void setMaxCapacity(int MaxCapacity) {
        this.MaxCapacity = MaxCapacity;
    }

    public int getCurrVisitors() {
        return currVisitors;
    }

    public void setCurrVisitors(int currVisitors) {
        this.currVisitors = currVisitors;
    }

    public boolean isAreaOpen() {
        return areaOpen;
    }

    public void setAreaOpen(boolean areaOpen) {
        this.areaOpen = areaOpen;
    }

    public WariningType getIsWarned() {
        return isWarned;
    }

    public void setIsWarned(WariningType isWarned) {
        this.isWarned = isWarned;
    }

    public VDMSequence getRequestQ() {
        return RequestQ;
    }

    public void setRequestQ(VDMSequence RequestQ) {
        this.RequestQ = RequestQ;
    }
    
    
    
}
