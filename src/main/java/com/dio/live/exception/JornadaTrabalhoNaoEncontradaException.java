package com.dio.live.exception;

public class JornadaTrabalhoNaoEncontradaException extends Exception{

	private static final long serialVersionUID = -3023851070303333036L;

	public JornadaTrabalhoNaoEncontradaException() {
        super("Jornada não encontrada!");
    }

    public JornadaTrabalhoNaoEncontradaException(String message) {
        super(message);
    }

    public JornadaTrabalhoNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public JornadaTrabalhoNaoEncontradaException(Throwable cause) {
        super(cause);
    }
}
