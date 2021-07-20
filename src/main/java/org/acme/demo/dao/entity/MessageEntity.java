package org.acme.demo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "log_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MsgSequenceGenerator")
	@SequenceGenerator(allocationSize=1, schema="teste",  name="MsgSequenceGenerator", sequenceName = "mgsequence")
    @Column(name = "message_id")
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "type_id")
    private Long idType;
}
