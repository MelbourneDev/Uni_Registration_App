package course_reg_app.controllers

import course_reg_app.models.APIResponses
import course_reg_app.models.Department
import course_reg_app.repository.DepartmentRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/department")

class Department_Controller (

    private val departmentRepository: DepartmentRepository,

)
    {

    @PostMapping("/choices")
            fun departmentChoices(@RequestBody department: Department): ResponseEntity<Any> {

            val savedChoice = departmentRepository.save(department)
        return ResponseEntity.ok(APIResponses.DepartmentResponse("You have joined the college of ${department.name}! "))

            }


    }