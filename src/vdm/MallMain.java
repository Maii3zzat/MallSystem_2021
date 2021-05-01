
package vdm;
import java.util.*;
/**
 *
 * @author Cherine.Mohamed
 */

enum FaceMaksStatus {ON,OFF};
enum AreaType{SHOP ,RESTAURANT , CENIMA , SUPERMARKET};
enum ReservationStatus {NoReservation ,ShopReservation,RestaurantReservation,CenimaReservation,SuperMarketReservation};
enum WariningType{ReachMaxCapacity,ShopSocialDistancing,FaceMask,None};
enum transportation {Stair ,Escalator ,Elevator};


public class MallMain {

        public static void main(String args[]) //han7ot feh ely fi el values 
    {

                                MallState c = new MallState();
                //    public Shop(int id, String name, int AreaSize, AreaType type, int FloorLevel, int MaxCapacity, int currVisitors, boolean areaOpen, WariningType isWarned
                    Shop Restaurant = new Shop(1,"Burger King",300,AreaType.RESTAURANT,1,150,0,false,WariningType.None);
                    Shop Cenima = new Shop(2,"VIP Cenima",500,AreaType.CENIMA,1,250,0,true,WariningType.None);
                    Shop SuperMarket = new Shop(3,"Helal Supermarket",200,AreaType.SUPERMARKET,1,100,0,true,WariningType.None);
                    Shop shop = new Shop(4,"Hamada electronics",250,AreaType.SHOP,2,125,0,true,WariningType.None);
                    Shop FullShop = new Shop(5,"Adidas",350,AreaType.SHOP,2,175,175,true,WariningType.None);
                   
                    c.ALLShops.theSet.add(Restaurant);
                    c.ALLShops.theSet.add(Cenima);
                    c.ALLShops.theSet.add(SuperMarket);
                    c.ALLShops.theSet.add(shop);
                    c.ALLShops.theSet.add(FullShop);
                    
                    c.allShops.theSequence.add(Restaurant);
                    c.allShops.theSequence.add(Cenima);
                    c.allShops.theSequence.add(SuperMarket);
                    c.allShops.theSequence.add(shop);
                    c.allShops.theSequence.add(FullShop);
 
                    
                  
                    Floor FirstFloor = new Floor(1,1,1000,500,0,true,WariningType.None);
                    Floor SecondFloor = new Floor(2,2,1000,500,0,true,WariningType.None);
                    
                    FirstFloor.getShopsInside().theSequence.add(Restaurant);
                    FirstFloor.getShopsInside().theSequence.add(Cenima);
                    FirstFloor.getShopsInside().theSequence.add(SuperMarket);
                    SecondFloor.getShopsInside().theSequence.add(shop);
                    SecondFloor.getShopsInside().theSequence.add(FullShop);
                    
                    c.ALLFloors.theSet.add(FirstFloor);
                    c.ALLFloors.theSet.add(SecondFloor);
               
                   Customer FullCust = new Customer(1,"Hamda",20,'M',FaceMaksStatus.ON,ReservationStatus.NoReservation,WariningType.None);
                   Customer FullCust2 = new Customer(2,"Omar",25,'M',FaceMaksStatus.ON,ReservationStatus.NoReservation,WariningType.None);
                   Customer FullCust3 = new Customer(3,"Salma",38,'F',FaceMaksStatus.ON,ReservationStatus.NoReservation,WariningType.None);
                   Customer FullCust4 = new Customer(4,"Rafik",18,'M',FaceMaksStatus.ON,ReservationStatus.NoReservation,WariningType.None);
                   Customer FullCust5 = new Customer(5,"Mariam",23,'F',FaceMaksStatus.ON,ReservationStatus.NoReservation,WariningType.None);
                      c.TotalVistis.theSequence.add(FullCust);
                      c.TotalVistis.theSequence.add(FullCust2);
                      c.TotalVistis.theSequence.add(FullCust3);
                      c.TotalVistis.theSequence.add(FullCust4);
                      c.TotalVistis.theSequence.add(FullCust5);
                      
                   /*
                           c.LeaveArea(Restaurant,FirstFloor, FullCust);
                           c.LeaveArea(Cenima,SecondFloor, FullCust3);
                           c.LeaveArea(SuperMarket,SecondFloor, FullCust2);
                     */ 
                      
                      
                      
                    MainMenu(c);


    }
        public static void MainMenu(MallState c){
       
       Shop shoptemp;
       Customer custTemp;
       Floor floortemo;
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the Function you want to test ................");
        System.out.println("To test UpdateAllCapacity() ........................press 1");
        System.out.println("To test acceptVisitRequest()........................press 2");
        System.out.println("To test rejectVisitRequest()........................press 3");
        System.out.println("To test SendWarning()...............................press 4");
        System.out.println("To test CustomerWarning()...........................press 5");
        System.out.println("To test MallEntryQueue()............................press 6");
        System.out.println("To test checkSocialDistancing().....................press 7");
        System.out.println("To test closeArea().................................press 8");
        System.out.println("To test openArea()..................................press 9");
        System.out.println("Exit ...............................................press 0");
        int res = s.nextInt();
        switch(res){
            case 1:
 
                    System.out.println("Please Enter the regulation percentage  .....(numbers between 0 than 1)");
                    double r = s.nextDouble();
                    try{
                    c.UpdateAllCapacity(r);
                    System.out.println("New Shop Capacity:");
                    for (int i=0;i<c.ALLShops.card();i++){
                    shoptemp = (Shop) c.ALLShops.theSet.elementAt(i);
                    System.out.println("Shop"+(i+1) +" "+ shoptemp.getMaxCapacity());
                                                            } 
                    System.out.println("New Floor Capacity:");
                             for (int i=0;i<c.ALLFloors.card();i++){
                             floortemo = (Floor) c.ALLFloors.theSet.elementAt(i);
                             System.out.println("Floor"+(i+1) +" "+ floortemo.getMaxCapacity());
        }
                    
                    }catch (VDMException q){
                q.printStackTrace();
                    }
                    MainMenu(c);
            case 2: 
               shoptemp= (Shop) c.ALLShops.theSet.elementAt(3);
                
                 try{
                     for(int i=0;i<c.TotalVistis.len();i++){
                     
                    custTemp=(Customer) c.TotalVistis.theSequence.elementAt(i);
                    c.acceptVisitRequest(custTemp, shoptemp);
                     }
                    }catch (VDMException q){
                        q.printStackTrace();
                    }
                 System.out.println("Customers Inside " + shoptemp.getName());
                    for (int i=0;i<shoptemp.getCurrVisitors();i++){
                    custTemp = (Customer) shoptemp.getVisitCust().theSet.elementAt(i);
                    System.out.println("CustomerID:"+custTemp.getCustID() +" Name: "+custTemp.getName() +"  Reservation Type: "+custTemp.getReservation()); 
                    }                    
                 MainMenu(c);
            case 3: 
                shoptemp= (Shop) c.ALLShops.theSet.elementAt(4);
                 try{
                     for(int i=0;i<c.TotalVistis.len();i++){
                     custTemp=(Customer) c.TotalVistis.theSequence.elementAt(i);
                     c.rejectVisitRequest(custTemp, shoptemp);
                     }
                 }catch (VDMException q){
                        q.printStackTrace();
                    }
                         System.out.println("ID of customers in requestQ of the Full shop");
                  
                         for (int i=0;i<shoptemp.getRequestq().len();i++){
                        custTemp = (Customer)shoptemp.getRequestq().theSequence.elementAt(i);
           
                        System.out.println(custTemp.getCustID());
                         }   
                         MainMenu(c);
            case 4:

          
               System.out.println(" if you desire to send a warning , press 1 , other wise press 0 to Exit");
               int choice2 = s.nextInt(); 
               try{
                   
               if (choice2 == 1 ) 
               {
               System.out.println(" please Enter the shop id  you want to send a warning to ");
               int choiceid =s.nextInt();
               
                Shop temp; //temp id to fetch the object that match user's input
    
                  for (int i=0;i<c.ALLShops.card();i++){ //search in the list of all shops 
                 temp = (Shop) c.ALLShops.theSet.elementAt(i); 
                 
                  if(temp.getId() == choiceid) { //check to match the user's input
                      c.SendWarning(temp); // if the shop found the system sends this shop to sendwarning function where it carry the rest
                      System.out.println("Warning sent");
                  }
               else { 
                }//this means that the shop id  was wrong or didnt exsists
                      }
                  
         
               } //end of if condtion incase user choose to sned warning
               else //else incase the user does not want to send a warning anymore
               {//System. exit(0);
                MainMenu(c);}
           
        
           }
           catch ( VDMException e){ 
           e.printStackTrace();
        System.out.print(e);
           }
       
       
       
       
       
       
       break;
       case 5:
       
       // call function 2 
       try{
       
        System.out.println(" if you desire to send warning to customer with no mask , press 1 , other wise press 0 to Exit");
               int case2choice2 = s.nextInt(); 
       if ( case2choice2 == 1){ //confirm that the users wants to send a customer warning
       
        //preparing for send  customer warning function
               System.out.println(" please Enter the cutomer's id that you want to send a warning to ");
               int choiceid =s.nextInt();
                
              Customer temp; 
               
       for (int i=0;i<c.TotalVistis.len();i++){ //search in the list of all customers
                 temp = (Customer) c.TotalVistis.theSequence.elementAt(i); 
                 if (temp.getCustID()== choiceid){
                 c.CustomerWarning(temp);
                 System.out.println("Warning sent");
                 
                 }
                 // else {System.out.println(" the id you entered is incorrect or does not exists in the system");}
       
    
          }
       
       }// end of for loop for searching customer
      
       else  //ethe user doesnt want to send customer a warning
       {// System. exit(0);
        MainMenu(c);
       }
       
       
      
       
       }//try
      
     catch ( VDMException e ){
     e.printStackTrace();
        System.out.print(e);
     }  
    
    break;
    
    
    case 6: //my third case mall entry qeue //this function takes shop and customer objects
        
        try{
            
             System.out.println(" if you desire to enter the mall , press 1 , other wise press 0 to Exit");
               int case12choice2 = s.nextInt(); 
                if ( case12choice2 == 1) 
                {
                
                System.out.println("please enter the customer's id");
                int cusid =s.nextInt();
                System.out.println("Thank you , now please enter the shop id you want to enter");
                int shid = s.nextInt();
                
                 Customer tempobj;  
                 Shop tempshop;
                 
                 for (int i=0;i<c.TotalVistis.len();i++) // to check the list of users in the system
                 {
                 tempobj = (Customer) c.TotalVistis.theSequence.elementAt(i);
                  if (tempobj.getCustID()== cusid) //if the id matches 
                  {
             //     tempobj= (Customer) c.TotalVistis.theSequence.elementAt(i); //hold the match customer in temp varable to be passed 
                  
               
                  for (int j=0;j<c.ALLShops.card();i++){ //search in the list of all shops 
                 tempshop = (Shop) c.ALLShops.theSet.elementAt(j); 
                 if( tempshop.getId() == shid ){
                     c.MallEntryQueue(tempobj, tempshop); //calling the function
                     System.out.println("Success");
                 
                 } //else { System.out.println(" the shop id you entered is incorrect");
                 
                  MainMenu(c);
                 
                 //}
                 
                   }
                 
                  } // end if cust id
                  else {//System.out.println("invaild user id");
                  
                  
                  }
                 
                 
                 }
               
                
                
                }
                else 
                {
                    //System. exit(0);
                     MainMenu(c);
                }
               
        
      
        
        }
        catch (VDMException e ){
        e.printStackTrace();
        System.out.print(e);
        }
            case 0: 
                break;
    case 7: 
               try{
                System.out.println("All shops which violates Social Distancing will be warned.");
                  if(true){ 
                   for(int i=0; i< c.allShops.len();i++){
                    Shop listOfShops = (Shop) c.allShops.theSequence.elementAt(i);
                    c.checkSocialDistancing(listOfShops);
                    if(listOfShops.isAreaOpen()==true && listOfShops.getIsWarned() != WariningType.None){
                       
                       System.out.println(" shop " + listOfShops.getName() + " violates the regulations and is sent a warning.");
                       
                       
                    }else if(listOfShops.isAreaOpen()==false && listOfShops.getIsWarned() != WariningType.None){
                          System.out.println(" shop " + listOfShops.getName() + " is closed due to violations.");
                    }else if(listOfShops.isAreaOpen()==false){
                        System.out.println(" shop " + listOfShops.getName() + " is already closed.");
                    }else{
                         System.out.println(" shop " + listOfShops.getName() + " is following social distancing regulations, yay!");
                    }
                   }
                    System.out.println(c.allShops.toString());
               }
               }catch(VDMException e){
                    System.out.println(e);
                  }
                         MainMenu(c);
           case 8: 
               try{
                   
                  System.out.println("All shops which reached max capacity or has customers with no face-masks"
                          + " or violates social distancing regulations will be closed");
                  if(true){ 
                   for(int i=0; i< c.allShops.len();i++){
                    Shop listOfShops = (Shop) c.allShops.theSequence.elementAt(i);
                 /*   if(listOfShops.getIsWarned() != WariningType.None){
                       c.closeArea(listOfShops);
                       System.out.println(" shop " + listOfShops.getName() + " is closed due to warnings.");
                    }
                   else if(listOfShops.isAreaOpen()==false && listOfShops.getIsWarned() == WariningType.None){
                      System.out.println(" shop " + listOfShops.getName() + " is closed.");*/
                    if(listOfShops.isAreaOpen()==false && listOfShops.getIsWarned() == WariningType.None){
                      System.out.println(" shop " + listOfShops.getName() + " is closed.");
                      
                      } else if(listOfShops.getIsWarned() != WariningType.None){
                       c.closeArea(listOfShops);
                       //System.out.println(" shop " + listOfShops.getName() + " is closed due to warnings.");
                       System.out.println(" shop " + listOfShops.getName() + " is closed due to " + listOfShops.getIsWarned() + " warning.");
                    }                  
                   
                      
                    else{
                        System.out.println(" shop " + listOfShops.getName() + " is open and clear of Covid-19!.");
                    }
                   }
                    System.out.println(c.allShops.toString());
                   }
               }catch(VDMException e){
                    System.out.println(e);
                  }
                      MainMenu(c);

           case 9: 
               try{
                   System.out.println("All closed shops which has no warnings will be opened.");
                   if(true){
                   
                    for(int i=0; i< c.allShops.len();i++){
                    Shop listOfShops = (Shop) c.allShops.theSequence.elementAt(i);
                    if(listOfShops.isAreaOpen() == false && listOfShops.getIsWarned()== WariningType.None){
                         c.openArea(listOfShops);
                         System.out.println(" shop " + listOfShops.getName() + " is now open.");
                    }else if(listOfShops.getIsWarned()!= WariningType.None){
                        System.out.println(" shop " + listOfShops.getName() + " will remain closed due to warnings.");
                     }
                    else{
                        System.out.println(" shop " + listOfShops.getName() + " is already open.");
                    }
                    }
                    
                     System.out.println(c.allShops.toString());
                   }
                   
               }catch(VDMException e){
                    System.out.println(e);
                  }
                      MainMenu(c);

        }
      // System.exit(0);
        }
      }
                
        
 
        
        
        
    
