package rustamscode.kotlincrud.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import rustamscode.kotlincrud.entity.Message
import rustamscode.kotlincrud.repository.MessageRepository

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList();

    fun findMessageById(id: String): Message? = db.findByIdOrNull(id);

    fun save(message: Message): Message {
        return db.save(message);
    }
}