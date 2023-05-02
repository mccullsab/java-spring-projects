package com.abbymcculloch.lighthouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbymcculloch.lighthouse.models.Message;
import com.abbymcculloch.lighthouse.repositories.MessageRepository;


@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepo;
	
//	FIND ALL-------------
	public List<Message> allMessages(){
		return messageRepo.findAll();
	}
	
//	CREATE -------------

	public Message createMessage(Message newMessage) {
		return messageRepo.save(newMessage);
	}
	
//	FIND ONE-------------

	public Message findMessage(Long id) {
        Optional<Message> optionalMessage = messageRepo.findById(id);
        if(optionalMessage.isPresent()) {
            return optionalMessage.get();
        } else {
            return null;
        }
    }
	
//	UPDATE -------------
	public Message updateMessage(Message oneMessage) {
		return messageRepo.save(oneMessage);
	}
	
//	DELETE-------------
	public void removeMessage(Long id) {
		messageRepo.deleteById(id);
	}
}
