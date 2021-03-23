package bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones;

public class ExcepcionNroVerticesInvalido_1 extends Exception {
	public ExcepcionNroVerticesInvalido_1() {
		super("Arista ya existe");
	}
	public ExcepcionNroVerticesInvalido_1(String message) {
		super(message);
	}
}
