package org.javabrain.rest;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;


public class Request extends LinkedHashMap<String, Object> {

	public static Object test(Object object) {
		System.out.println(object.getClass().getDeclaredMethods());
		try {
			for (Method declaredMethod : object.getClass().getDeclaredMethods()) {
				if (declaredMethod.getName().equals("findById")) {
					return declaredMethod.invoke(object, 1L);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public static void to(KClass kClass, List<String> key, List<Object> daos) {
		Class clazz = JvmClassMappingKt.getJavaClass(kClass);
		for (Field declaredField : clazz.getDeclaredFields()) {
			System.out.println(declaredField);
		}
	}



}
