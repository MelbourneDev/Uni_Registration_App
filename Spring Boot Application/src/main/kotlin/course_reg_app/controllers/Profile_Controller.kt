package course_reg_app.controllers

import course_reg_app.models.APIResponses
import course_reg_app.models.Profile
import course_reg_app.repository.ProfileRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/profile")
class Profile_Controller (

    private val profileRepository: ProfileRepository,

    )
{    @Transactional
    @PostMapping("/details")
    fun userDetails(@RequestBody profile: Profile): ResponseEntity<Any> {
        // if the profile fields are not filled out then give bad request
        if (areFieldsEmpty(profile)){
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(APIResponses.UserDetailsResponse("Please fill in all fields."))
        }

    // if all details are filled in then save profile to database
    val saveProfile = profileRepository.save(profile)
        return ResponseEntity.ok(saveProfile)

    }
    fun areFieldsEmpty(request: Profile): Boolean {
        return request.firstName.isEmpty() ||
                request.lastName.isEmpty() ||
                request.dateOfBirth == null ||
                request.gender.isEmpty() ||
                request.contactNumber.isEmpty() ||
                request.address.isEmpty()
    }


}



// THINGS TO DO: EVENTUALLY SET UP THE CONTROLLER TO TAKE IN SAVED USERID (FROM REGISTRATION)
// AS A VARIABLE IN THE MAPPING.