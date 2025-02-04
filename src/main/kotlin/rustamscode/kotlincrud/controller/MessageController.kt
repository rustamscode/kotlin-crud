package rustamscode.kotlincrud.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import rustamscode.kotlincrud.entity.Message
import rustamscode.kotlincrud.service.MessageService
import java.net.URI

@RestController
@RequestMapping("/")
class MessageController(private val service: MessageService) {

    @GetMapping
    fun listMessages() = service.findMessages();

    @PostMapping
    fun post(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<Message> =
        ResponseEntity.ok(service.findMessageById(id))

    private fun Message?.toResponseEntity(): ResponseEntity<Message> =
        this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}