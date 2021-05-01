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
public class Shop {
    private int id;
    private String name;
    private int AreaSize;
    private AreaType type;
    private int FloorLevel;
    private int MaxCapacity;
    private int currVisitors;
    private boolean areaOpen;
    private WariningType isWarned;
    private VDMSet VisitCust;
    private VDMSequence Requestq;
    private VDMSequence LeaveQ;




    

    public Shop(int id, String name, int AreaSize, AreaType type, int FloorLevel, int MaxCapacity, int currVisitors, boolean areaOpen, WariningType isWarned) {
        this.id = id;
        this.name = name;
        this.AreaSize = AreaSize;
        this.type = type;
        this.FloorLevel = FloorLevel;
        this.MaxCapacity = MaxCapacity;
        this.currVisitors = currVisitors;
        this.areaOpen = areaOpen;
        this.isWarned = isWarned;
        VisitCust = new VDMSet();
        Requestq = new VDMSequence();
        LeaveQ = new VDMSequence();
        
    }

   
    
    
    
    public int getAreaSize() {
        return AreaSize;
    }

    public void setAreaSize(int AreaSize) {
        this.AreaSize = AreaSize;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AreaType getType() {
        return type;
    }

    public void setType(AreaType type) {
        this.type = type;
    }

    public int getFloorLevel() {
        return FloorLevel;
    }

    public void setFloorLevel(int FloorLevel) {
        this.FloorLevel = FloorLevel;
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

    public VDMSet getVisitCust() {
        return VisitCust;
    }

    public void setVisitCust(VDMSet VisitCust) {
        this.VisitCust = VisitCust;
    }

    public VDMSequence getRequestq() {
        return Requestq;
    }

    public void setRequestq(VDMSequence Requestq) {
        this.Requestq = Requestq;
    }

    public VDMSequence getLeaveQ() {
        return LeaveQ;
    }

    public void setLeaveQ(VDMSequence LeaveQ) {
        this.LeaveQ = LeaveQ;
    }

    @Override
    public String toString() {
        return "Shop{" + "id=" + id + ", name=" + name + ", AreaSize=" + AreaSize + ", type=" + type + ", FloorLevel=" + FloorLevel + ", MaxCapacity=" + MaxCapacity + ", currVisitors=" + currVisitors + ", areaOpen=" + areaOpen + ", isWarned=" + isWarned + ", VisitCust=" + VisitCust + ", Requestq=" + Requestq + ", LeaveQ=" + LeaveQ + '}';
    }
    
    
    
}
