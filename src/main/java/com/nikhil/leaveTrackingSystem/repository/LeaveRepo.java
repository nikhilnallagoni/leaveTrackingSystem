package com.nikhil.leaveTrackingSystem.repository;//package com.nikhil.leaveTrackingSystem.repository;

import com.nikhil.leaveTrackingSystem.model.ApproveLeaveModel;
import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import com.nikhil.leaveTrackingSystem.model.LeaveTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveModel,Integer> {
    @Query(value = "select * from leaves where status=0",nativeQuery = true)
    public List<LeaveModel> findPendingLeaves();

    @Modifying
    @Query(value = "UPDATE leaves as l SET l.status = :status, l.comment = :comment WHERE l.id = :id",nativeQuery = true)
    void approveLeaveById(@Param("status") Boolean status, @Param("comment") String comment, @Param("id") int id);

    @Query(value = "SELECT * from leaves where employee_id= :emp_id", nativeQuery = true)
    public List<Optional<LeaveModel>>findLeavesById(@Param(value = "emp_id") int emp_id);


    @Query(value = "type",nativeQuery = true)
    public List<LeaveTypeDTO>getOverview(@Param(value = "type") String q);
}


