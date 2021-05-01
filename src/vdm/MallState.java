
package vdm;



public class MallState  implements InvariantCheck
{
    // State Attributes
    VDMSet ALLShops;
    VDMSequence allShops;
    VDMSequence TotalVistis;
    VDMSequence CustReqQueue;
    VDMSet ALLFloors;
    VDMSet BannedCustomers;
    VDMSequence BannedShop;
    VDMSequence ALLFloorConnectors;
    // Initialize the State   
    public MallState()
    {   
        ALLShops = new VDMSet();
        allShops = new VDMSequence();
        TotalVistis = new VDMSequence();
        CustReqQueue = new VDMSequence();
        ALLFloors = new VDMSet();
        BannedCustomers = new VDMSet(); 
        BannedShop = new VDMSequence();
        ALLFloorConnectors = new VDMSequence();
        
        VDM.invTest(this);
    }
    // State Invariant   
    public boolean inv()
    {
        
        return (TotalVistis.len() <=800 && ALLShops.doesNotContain(BannedCustomers)&& ALLFloors.doesNotContain(BannedCustomers) && TotalVistis.elems().doesNotContain(BannedCustomers));
  
    }

    // Operations
  public void UpdateAllCapacity(double newRate){
 VDM.preTest(newRate <1 && newRate >0);
 
  Shop shoptemp;
  VDMSet tempARR = new VDMSet();
  Floor Floortemp;
  VDMSet FloortempARR = new VDMSet();
  for (int i=0;i<ALLShops.card();i++){
      shoptemp = (Shop) ALLShops.theSet.elementAt(i);
      shoptemp.setMaxCapacity((int) (newRate * shoptemp.getAreaSize()));
      tempARR.theSet.add(shoptemp);
  }
    for (int i=0;i<ALLFloors.card();i++){
        Floortemp = (Floor) ALLFloors.theSet.elementAt(i);
        Floortemp.setMaxCapacity((int) (newRate* Floortemp.getAreaSize()));
        FloortempARR.theSet.add(Floortemp);
    }
    
    
    
ALLShops = tempARR;
ALLFloors = FloortempARR;
VDM.postTest(ALLShops == tempARR && ALLFloors == FloortempARR); 
VDM.invTest(this);
      }
  
  public void acceptVisitRequest(Customer cust,Shop shop){
VDM.preTest(shop.getCurrVisitors() < shop.getMaxCapacity());
  if (shop.getCurrVisitors() < shop.getMaxCapacity() && shop.getType() == AreaType.SHOP ){
         shop.setCurrVisitors(shop.getCurrVisitors()+1);
         shop.getVisitCust().theSet.add(cust);
         cust.setReservation(ReservationStatus.ShopReservation);
  }  
    if (shop.getCurrVisitors() < shop.getMaxCapacity() && shop.getType() == AreaType.RESTAURANT ){
         shop.setCurrVisitors(shop.getCurrVisitors()+1);
         shop.getVisitCust().theSet.add(cust);
         cust.setReservation(ReservationStatus.RestaurantReservation);
  }  
       if (shop.getCurrVisitors() < shop.getMaxCapacity() && shop.getType() == AreaType.CENIMA ){
           shop.setCurrVisitors(shop.getCurrVisitors()+1);
           shop.getVisitCust().theSet.add(cust);
           cust.setReservation(ReservationStatus.CenimaReservation);
  }  
      if (shop.getCurrVisitors() < shop.getMaxCapacity() && shop.getType() == AreaType.CENIMA ){
          shop.setCurrVisitors(shop.getCurrVisitors()+1);
          shop.getVisitCust().theSet.add(cust);
          cust.setReservation(ReservationStatus.CenimaReservation);
  }  
        if (shop.getCurrVisitors() < shop.getMaxCapacity() && shop.getType() == AreaType.SUPERMARKET ){
          shop.setCurrVisitors(shop.getCurrVisitors()+1);
          shop.getVisitCust().theSet.add(cust);
          cust.setReservation(ReservationStatus.SuperMarketReservation);
          
  }  
        VDM.invTest(this);
  //      VDM.postTest((int)shop.getCurrVisitors() == test+1 ); 
  }
  
  public void rejectVisitRequest(Customer cust,Shop shop){
      VDM.preTest(shop.getCurrVisitors() >= shop.getMaxCapacity());
      VDMSequence d = new VDMSequence();
      int PreviousValue = (int) shop.getRequestq().len();
      d.theSequence.add(cust);
      cust.setReservation(ReservationStatus.NoReservation);
      shop.setRequestq(shop.getRequestq().concat(d));
      VDM.postTest((int)shop.getRequestq().len() == PreviousValue+1);
      VDM.invTest(this);
  }
  //my operations 


    //---------------------------------------------Alaa169897-----------------
    
    /*
    public void  SendVisitRequest(int id , enum AreaType,Customer cust ,Shop shop ){
     Customer temcust;
     Shop shoptemp;
     //int shopid;
      //String AreaTemp;
     for (int i=0;i<ALLShops.card();i++){
      shoptemp = (Shop) ALLShops.theSet.elementAt(i);
      VDM.preTest(true);
     if((shoptemp.getId() == id) && (shoptem.getType() == AreaType )
             && (shop.getCurrVisitors() < shop.getMaxCapacity() )
             &&(cust.getFacemask()== FaceMaksStatus.ON))
        
      {
      temcust = acceptVisitRequest(Customer cust,Shop shop);
      VDM.postTest(acceptVisitRequest(Customer cust,Shop shop));
      }
     else {
      temcust = rejectVisitRequest(Customer cust,Shop shop);
      VDM.postTest(rejectVisitRequest(Customer cust,Shop shop));
     }
  
  }
  
  
  VDM.invTest(this);
  }
    */
    
    public void SendWarning(Shop shop) {
        Shop loopTemp;

        VDM.preTest(true);
        for (int i=0;i<ALLShops.card();i++){
            loopTemp =(Shop) ALLShops.theSet.elementAt(i);
        if (shop.getCurrVisitors() > shop.getMaxCapacity())
        {
            System.out.println((loopTemp));
        shop.setIsWarned(WariningType.ReachMaxCapacity);
        
     //   VDM.postTest(loopTemp.setIsWarned(WariningType.ReachMaxCapacity));

        }

       }
       VDM.invTest(this);
 
}
    
    public void MallEntryQueue(Customer cust,Shop shop){
    
        VDM.preTest(cust.getFacemask() == FaceMaksStatus.ON);

       if (cust.getReservation()!= ReservationStatus.NoReservation)
       {

       acceptVisitRequest( cust, shop);
      // VDM.postTest(acceptVisitRequest( cust, shop));
      System.out.print("Accepted!");
       }
       else 
       {
       rejectVisitRequest( cust, shop);
       System.out.print("Rejected!");
    //   VDM.postTest(rejectVisitRequest( cust, shop));
       }

       VDM.invTest(this);

       }   

     public void CustomerWarning (Customer cust) {
        VDM.preTest(true);
        if ( cust.getFacemask() == FaceMaksStatus.OFF )
        {
        BannedCustomers.theSet.add(cust);
         System.out.println("this customer is banned");
        }

        System.out.println("the function is done");
        VDM.postTest(BannedCustomers.theSet.add(cust));
        VDM.invTest(this);

 
 
 }
     
   //-----------------------------------------------------Mai146607----------
  
  
  
  
  
     public boolean openArea(Shop s){
        VDM.preTest(true);
        s.setAreaOpen(true);
        VDM.postTest(s.isAreaOpen()== true);
        return s.isAreaOpen();
    }
   
    public boolean closeArea(Shop s){
        VDM.preTest(true);
        s.setAreaOpen(false);
        VDM.postTest(s.isAreaOpen() == false);
        return s.isAreaOpen();
    }
    
    public void checkSocialDistancing(Shop s){
        VDM.preTest(s.getIsWarned()== WariningType.None);
        int preShop,currShop,postShop;
        Shop pre,curr, post;
        
        for(int i=0; i < allShops.len(); i++ ){
            if(allShops.theSequence.elementAt(i).equals(s)){

            curr = (Shop) allShops.theSequence.elementAt(i);
            currShop = curr.getCurrVisitors();
            

            if( s.equals(allShops.theSequence.lastElement())){
                pre = (Shop) allShops.theSequence.elementAt(i-1);
                preShop = pre.getCurrVisitors();
                if((preShop + currShop > 48)){
                    s.setIsWarned(WariningType.ShopSocialDistancing);
                    VDM.postTest(s.getIsWarned()== WariningType.ShopSocialDistancing);
                }
            }
            else if( s.equals(allShops.theSequence.firstElement())){
                post = (Shop) allShops.theSequence.elementAt(i+1);
                postShop = post.getCurrVisitors();
                if( (currShop + postShop > 48)){
                    s.setIsWarned(WariningType.ShopSocialDistancing);
                    VDM.postTest(s.getIsWarned()== WariningType.ShopSocialDistancing);
                }
            }
            else if(!(s.equals(allShops.theSequence.lastElement()))){
                pre = (Shop) allShops.theSequence.elementAt(i-1);
                preShop = pre.getCurrVisitors();
                post = (Shop) allShops.theSequence.elementAt(i+1);
                postShop = post.getCurrVisitors();
                
                if(((preShop + currShop) > 48) || (( currShop + postShop) > 48)){
                
                    s.setIsWarned(WariningType.ShopSocialDistancing);
                    VDM.postTest(s.getIsWarned()== WariningType.ShopSocialDistancing);
                   
              }
             }else {
                System.out.print("Shop doesn't exist!");
            }
            }
        }
        
    }
    
    
    

    @Override
    public String toString() {
        return "MallState{" + "ALLShops=" + ALLShops + ", allShops=" + allShops + ", TotalVistis=" + TotalVistis + ", CustReqQueue=" + CustReqQueue + ", ALLFloors=" + ALLFloors + ", BannedCustomers=" + BannedCustomers + ", BannedShop=" + BannedShop + '}';
    }
     public void LeaveArea(Shop shop, Floor floor, Customer cust){
        VDM.preTest(floor.getCurrVisitors()< floor.getMaxCapacity());
        shop.setCurrVisitors(shop.getCurrVisitors()-1);
        if((int) shop.getRequestq().len() != 0){
         acceptVisitRequest(cust, shop);
         shop.getRequestq().theSequence.add(cust);
         shop.setCurrVisitors(shop.getCurrVisitors() + 1);
         ALLShops.theSet.add(shop);
         if (floor.getCurrVisitors() < floor.getMaxCapacity()){
         floor.setCurrVisitors(floor.getCurrVisitors() + 1);
         shop.setCurrVisitors(shop.getCurrVisitors() + 1);
         }
         if (floor.getCurrVisitors() >= floor.getMaxCapacity()){
             floor.getRequestQ().theSequence.add(cust);
             ALLFloors.theSet.add(floor);
         }
        VDM.postTest(ALLFloors.theSet.add(floor));
        VDM.invTest(this);
    }
  }
    
   public boolean GeneralReport(){
       VDM.preTest(true);
       Floor floortemp;
       Shop shoptemp;
       FloorConnector FCtemp;
       for(int i=0; i<ALLFloors.card();i++){
       floortemp = (Floor) ALLFloors.theSet.elementAt(i);
       if (floortemp.getIsWarned() == WariningType.ShopSocialDistancing || floortemp.getIsWarned() == WariningType.ReachMaxCapacity){
           System.out.println(floortemp);
       }
       }
       for(int i=0; i<ALLShops.card();i++){
       shoptemp = (Shop) ALLShops.theSet.elementAt(i);
       if (shoptemp.getIsWarned() == WariningType.ShopSocialDistancing || shoptemp.getIsWarned() == WariningType.ReachMaxCapacity){
           System.out.println(shoptemp);
       }
       }
       for(int i=0; i<ALLFloorConnectors.len();i++){
       FCtemp = (FloorConnector) ALLFloorConnectors.theSequence.elementAt(i);
       if (FCtemp.getIsWarned() == WariningType.ShopSocialDistancing || FCtemp.getIsWarned() == WariningType.ReachMaxCapacity){
           System.out.println(FCtemp);
       }
       }
       VDM.postTest(true);
       return true;
}
   public boolean AreaReport(){
       VDM.preTest(true);
       int max = 0;
       Shop shoptemp;
       for (int i = 0; i<ALLShops.card();i++){
       shoptemp = (Shop) ALLShops.theSet.elementAt(i);
       if (shoptemp.getCurrVisitors() > max){
       max = shoptemp.getCurrVisitors();
               }
       } 
       System.out.println(max);
       VDM.postTest(true);
       return true;
   }
  
}