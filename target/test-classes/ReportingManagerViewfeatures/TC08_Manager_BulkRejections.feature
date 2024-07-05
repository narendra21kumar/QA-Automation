#aFeature: Bulk Rejection and verify
 #
  #Background:
    #Given User login timesheet page for BulkRejection for manager view
 #
  #@manager
  #Scenario Outline: Bulk Rejection and verify
      #When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" for Rejection for manager view
      #When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" for Rejection for manager view
      #s #And Select the <Startdate> and <EndDate> for manager view
       #And search by "<name>" and click on checkBox for manager view
       #And Reject the timesheet by filling the Remarks as "<BulkRejection>" for manager view
   #	Examples:
     #| Startmonth | Startdate | EndMonth  | EndDate |    name                | BulkRejection |
     #| May 2024   |     26    | June 2024 |      8  |  Naveen Kumar Mummadi  | BulkRejection |
     #
     #
       #| Startdate  | EndDate  |
       #|      26    |    8     |