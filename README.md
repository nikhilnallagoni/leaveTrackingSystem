# leaveTrackingSystem

Please find the follwing api end point details below

for adding new employee in the database
# POST  1.http://localhost:8080/add-employee     
      body
      
      {
         "employee_id":109,
         "employee_name":"bhanu"
      }

for applying leave of a employee
# POST  2.http://localhost:8080/applyLeave/103
      body
      
      {
        "leaveType":"personal leave",
          "startDate":"15-02-2025",
          "endDate":"17-02-2025"
      }

getting pending leaves
# GET   3.http://localhost:8080/manager/pending-leaves


approving leaves
# POST  4.http://localhost:8080/manager/approve-leave
      body
      
      {
         "id":102,
         "status":true,
         "comment":"get proper suggestion from doctor"
      }

leave details of employee to check their status of leave
# GET   5.http://localhost:8080/leaves/101

to get overiew of leaves based on leave_type,comment,start_date,end_date
# GET   6.http://localhost:8080/manager/overview/leave_type
      overview parameters
      a) comment
      b) start_date
      c) end_date
      d)leave_type
          


