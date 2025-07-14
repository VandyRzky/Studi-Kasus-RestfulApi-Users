package studikasus.restfulapi.belajar.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import studikasus.restfulapi.belajar.model.WebResponse


@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(ex: IllegalArgumentException): ResponseEntity<WebResponse<String>> {
        val response = WebResponse<String>(
            data = null,
            errors = ex.message ?: "Terjadi kesalahan input"
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST) // 400
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneral(ex: Exception): ResponseEntity<WebResponse<String>> {
        val response = WebResponse<String>(
            data = null,
            errors = "Terjadi kesalahan sistem"
        )
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR) // 500
    }
}
