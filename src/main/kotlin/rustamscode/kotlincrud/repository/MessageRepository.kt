package rustamscode.kotlincrud.repository

import org.springframework.data.repository.CrudRepository
import rustamscode.kotlincrud.entity.Message

interface MessageRepository : CrudRepository<Message, String> {
}