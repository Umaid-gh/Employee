package io.umaid.springbootquickstarter.domain.responseEmployee;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class ResponseEmployee<T> {

	private T data;
	private String message;
	private int status;
}
