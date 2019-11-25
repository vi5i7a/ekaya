package mz.co.abslda.ekayaapi.fwk.jpa.entity.type;

import java.io.Serializable;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.PrimitiveType;
import org.hibernate.type.StringType;
import org.hibernate.type.descriptor.java.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.CharTypeDescriptor;

/**
 * @author Ivo Abdul
 */
public class OneZeroType extends AbstractSingleColumnStandardBasicType<Boolean>
		implements PrimitiveType<Boolean>, DiscriminatorType<Boolean> {

	/**
	* 
	*/
	private static final long serialVersionUID = -8241800477504228495L;

	public static final OneZeroType INSTANCE = new OneZeroType();

	public OneZeroType() {
		super(CharTypeDescriptor.INSTANCE, new BooleanTypeDescriptor('1', '0'));
	}

	@Override
	public String objectToSQLString(Boolean value, Dialect dialect) throws Exception {
		return StringType.INSTANCE.objectToSQLString(value.booleanValue() ? "1" : "0", dialect);
	}

	@Override
	public Boolean stringToObject(String xml) throws Exception {
		return this.fromString(xml);
	}

	@Override
	public String getName() {
		return "mz.co.abslda.ekayaapi.fwk.jpa.entity.type.OneZeroType";
	}

	@Override
	public Serializable getDefaultValue() {
		return Boolean.FALSE;
	}

	@Override
	public Class<Boolean> getPrimitiveClass() {
		return boolean.class;
	}
}
