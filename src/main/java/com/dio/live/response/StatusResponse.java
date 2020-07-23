package com.dio.live.response;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class StatusResponse {

	private long status;
	private String mensagem;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}


}
