package eserciziopattern.document;

public abstract class  Document {
	
	private String nome;
	private double size;
	
	
	
	
	public Document(String nome, double size) {
		super();
		this.nome = nome;
		this.size = size;
		
	}
	
	public abstract void open();
	
	public abstract void save();
	
	public abstract void view();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Document [nome=" + nome + ", size=" + size + "]";
	}

	
	
	
}