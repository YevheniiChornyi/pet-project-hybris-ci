# pet-project-hybris-ci

It is a Java pet project for Hybris Intership

## Description

Steps to interract:
1. Run ConsolestoreApplication on IDE. You should have MySql schema(settings on application.yaml).
2. Input login, even if u not authorizate before. 
3. choose command:
  <pre>a) CREATE_PRODUCT;</pre>
  <pre>b) CREATE_ORDER 
   Create Order with a list of the products specified by id. If u choose same id quantity will increment;</pre>
   
  <PRE> с) SHOW_ORDERS 
  List all orders;</PRE>
  
  <PRE> d) SHOW_ORDER_BY_ID; </PRE>
  
  <PRE> e)SHOW_PRODUCTS
   Show all products;</PRE>
  
  <PRE> f) TOTAL_QUANTITIES
  List all products, which have been ordered at least once, with total ordered quantity sorted descending by the quantity;</PRE>
      
  <PRE> j) REMOVE_PRODUCT 
  Remove product by ID if you enter a password(DELETE);</PRE>
      
  <PRE> h) DISCONNECT 
  Exit from application;</PRE>
    
  <PRE> i) HELP 
  List all command.</PRE>
    
  4. You can interract with commands until you will not choose Disconnect.
