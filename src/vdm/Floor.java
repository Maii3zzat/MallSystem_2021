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
public class Floor {
    private int id;
    private int FloorLevel;
    private VDMSequence shopsInside;
    private int areaSize;
    private int maxCapacity;
    private int currVisitors;
    private boolean areaOpen;
    private WariningType  isWarned;



    public Floor(int id, int FloorLevel, int areaSize, int maxCapacity, int currVisitors, boolean areaOpen, WariningType isWarned) {
        this.id = id;
        this.FloorLevel = FloorLevel;
        this.areaSize = areaSize;
        this.maxCapacity = maxCapacity;
        this.currVisitors = currVisitors;
        this.areaOpen = areaOpen;
        this.isWarned = isWarned;
        shopsInside = new VDMSequence();
        
    }
    
    
    
    
    private VDMSequence requestQ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorLevel() {
        return FloorLevel;
    }

    public void setFloorLevel(int FloorLevel) {
        this.FloorLevel = FloorLevel;
    }

    public VDMSequence getShopsInside() {
        return shopsInside;
    }

    public void setShopsInside(VDMSequence shopsInside) {
        this.shopsInside = shopsInside;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
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
        return requestQ;
    }

    public void setRequestQ(VDMSequence requestQ) {
        this.requestQ = requestQ;
    }
    
    
    
    
    
}
