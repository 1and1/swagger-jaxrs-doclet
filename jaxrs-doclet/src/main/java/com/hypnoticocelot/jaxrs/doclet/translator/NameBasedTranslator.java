package com.hypnoticocelot.jaxrs.doclet.translator;

import static com.hypnoticocelot.jaxrs.doclet.translator.Translator.OptionalName.presentOrMissing;

import com.hypnoticocelot.jaxrs.doclet.parser.AnnotationHelper;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Type;

public class NameBasedTranslator implements Translator {

	public OptionalName typeName(Type type) {
		String[] typeFormat = AnnotationHelper.typeOf(type.qualifiedTypeName());
		return presentOrMissing(typeFormat[0], typeFormat[1]);
	}

	public OptionalName fieldName(FieldDoc field) {
		return presentOrMissing(field.name());
	}

	public OptionalName methodName(MethodDoc method) {
		String name = null;
		if (method.name().startsWith("get") && method.name().length() > 3) {
			name = method.name().substring(3);
			name = name.substring(0, 1).toLowerCase() + (name.length() > 1 ? name.substring(1) : "");
		}
		return presentOrMissing(name);
	}

}
