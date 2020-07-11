package com.neo.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author alahan
 */
public final class StringUtils {
	/*
	 * ==========================================================================
	 * ==
	 */
	/* ������singleton�� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/** ���ַ����� */
	public static final String EMPTY_STRING = "";

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �пպ����� */
	/*                                                                              */
	/* ���·��������ж�һ���ַ����Ƿ�Ϊ�� */
	/* 1. null */
	/* 2. empty - "" */
	/* 3. blank - "ȫ���ǿհ�" - �հ���Character.isWhitespace�����塣 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ���ַ���ת���Է���html���
	 */
	public String escapeHtml(String s) {
		return org.apache.commons.lang.StringEscapeUtils.escapeHtml(s);
	}

	/**
	 * ����ַ����Ƿ�Ϊ <code>null</code> ����ַ��� <code>""</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isEmpty(null)      = true
	 *     StringUtil.isEmpty(&quot;&quot;)        = true
	 *     StringUtil.isEmpty(&quot; &quot;)       = false
	 *     StringUtil.isEmpty(&quot;bob&quot;)     = false
	 *     StringUtil.isEmpty(&quot;  bob  &quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ���Ϊ��, �򷵻� <code>true</code>
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}

	/**
	 * ����ַ����Ƿ��� <code>null</code> �Ϳ��ַ��� <code>""</code>��
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return �����Ϊ��, �򷵻� <code>true</code>
	 * 
	 * @see cn.gov.zftec.zw.commom.util.StringUtils#isEmpty(String)
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * ����ַ����Ƿ��ǿհף� <code>null</code> �����ַ��� <code>""</code> ��ֻ�пհ��ַ���
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isBlank(null)      = true
	 *     StringUtil.isBlank(&quot;&quot;)        = true
	 *     StringUtil.isBlank(&quot; &quot;)       = true
	 *     StringUtil.isBlank(&quot;bob&quot;)     = false
	 *     StringUtil.isBlank(&quot;  bob  &quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ���Ϊ�հ�, �򷵻� <code>true</code>
	 */
	public static boolean isBlank(String str) {
		int length;

		if ((str == null) || ((length = str.length()) == 0)) {
			return true;
		}

		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * ����ַ����Ƿ��ǿհף� <code>null</code> �����ַ��� <code>""</code> ��ֻ�пհ��ַ���
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ������ǿհ�, �򷵻� <code>true</code>
	 * 
	 * @see com.nonfamous.commom.util.StringUtils#isBlank(String)(String)
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Ĭ��ֵ������ */
	/*                                                                              */
	/* ���ַ���Ϊnull��empty��blankʱ�����ַ���ת����ָ����Ĭ���ַ����� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ����ַ����� <code>null</code> ���򷵻ؿ��ַ��� <code>""</code> �����򷵻��ַ�������
	 * 
	 * <pre>
	 * 
	 *     StringUtil.defaultIfNull(null)  = &quot;&quot;
	 *     StringUtil.defaultIfNull(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.defaultIfNull(&quot;  &quot;)  = &quot;  &quot;
	 *     StringUtil.defaultIfNull(&quot;bat&quot;) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return �ַ����������ַ��� <code>""</code>
	 */
	public static String defaultIfNull(String str) {
		return (str == null) ? EMPTY_STRING : str;
	}

	/**
	 * ����ַ����� <code>null</code> ���򷵻�ָ��Ĭ���ַ��������򷵻��ַ�������
	 * 
	 * <pre>
	 * 
	 *     StringUtil.defaultIfNull(null, &quot;default&quot;)  = &quot;default&quot;
	 *     StringUtil.defaultIfNull(&quot;&quot;, &quot;default&quot;)    = &quot;&quot;
	 *     StringUtil.defaultIfNull(&quot;  &quot;, &quot;default&quot;)  = &quot;  &quot;
	 *     StringUtil.defaultIfNull(&quot;bat&quot;, &quot;default&quot;) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * @param defaultStr
	 *            Ĭ���ַ���
	 * 
	 * @return �ַ��������ָ����Ĭ���ַ���
	 */
	public static String defaultIfNull(String str, String defaultStr) {
		return (str == null) ? defaultStr : str;
	}

	/**
	 * ����ַ����� <code>null</code> ����ַ��� <code>""</code> ���򷵻ؿ��ַ��� <code>""</code>
	 * �����򷵻��ַ�������
	 * 
	 * <p>
	 * �˷���ʵ���Ϻ� <code>defaultIfNull(String)</code> ��Ч��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.defaultIfEmpty(null)  = &quot;&quot;
	 *     StringUtil.defaultIfEmpty(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.defaultIfEmpty(&quot;  &quot;)  = &quot;  &quot;
	 *     StringUtil.defaultIfEmpty(&quot;bat&quot;) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return �ַ����������ַ��� <code>""</code>
	 */
	public static String defaultIfEmpty(String str) {
		return isEmpty(str) ? EMPTY_STRING : str;
	}

	/**
	 * ����ַ����� <code>null</code> ����ַ��� <code>""</code> ���򷵻�ָ��Ĭ���ַ��������򷵻��ַ�������
	 * 
	 * <pre>
	 * 
	 *     StringUtil.defaultIfEmpty(null, &quot;default&quot;)  = &quot;default&quot;
	 *     StringUtil.defaultIfEmpty(&quot;&quot;, &quot;default&quot;)    = &quot;default&quot;
	 *     StringUtil.defaultIfEmpty(&quot;  &quot;, &quot;default&quot;)  = &quot;  &quot;
	 *     StringUtil.defaultIfEmpty(&quot;bat&quot;, &quot;default&quot;) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * @param defaultStr
	 *            Ĭ���ַ���
	 * 
	 * @return �ַ��������ָ����Ĭ���ַ���
	 */
	public static String defaultIfEmpty(String str, String defaultStr) {
		return isEmpty(str) ? defaultStr : str;
	}

	/**
	 * ����ַ����ǿհף� <code>null</code> �����ַ��� <code>""</code> ��ֻ�пհ��ַ����򷵻ؿ��ַ���
	 * <code>""</code> �����򷵻��ַ�������
	 * 
	 * <pre>
	 * 
	 *     StringUtil.defaultIfBlank(null)  = &quot;&quot;
	 *     StringUtil.defaultIfBlank(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.defaultIfBlank(&quot;  &quot;)  = &quot;&quot;
	 *     StringUtil.defaultIfBlank(&quot;bat&quot;) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return �ַ����������ַ��� <code>""</code>
	 */
	public static String defaultIfBlank(String str) {
		return isBlank(str) ? EMPTY_STRING : str;
	}

	/**
	 * ����ַ����� <code>null</code> ����ַ��� <code>""</code> ���򷵻�ָ��Ĭ���ַ��������򷵻��ַ�������
	 * 
	 * <pre>
	 * 
	 *     StringUtil.defaultIfBlank(null, &quot;default&quot;)  = &quot;default&quot;
	 *     StringUtil.defaultIfBlank(&quot;&quot;, &quot;default&quot;)    = &quot;default&quot;
	 *     StringUtil.defaultIfBlank(&quot;  &quot;, &quot;default&quot;)  = &quot;default&quot;
	 *     StringUtil.defaultIfBlank(&quot;bat&quot;, &quot;default&quot;) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * @param defaultStr
	 *            Ĭ���ַ���
	 * 
	 * @return �ַ��������ָ����Ĭ���ַ���
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ȥ�հף���ָ���ַ����ĺ����� */
	/*                                                                              */
	/* ���·���������ȥһ���ִ��еĿհ׻�ָ���ַ��� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ��ȥ�ַ���ͷβ���Ŀհף�����ַ����� <code>null</code> ����Ȼ���� <code>null</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trim(null)          = null
	 *     StringUtil.trim(&quot;&quot;)            = &quot;&quot;
	 *     StringUtil.trim(&quot;     &quot;)       = &quot;&quot;
	 *     StringUtil.trim(&quot;abc&quot;)         = &quot;abc&quot;
	 *     StringUtil.trim(&quot;    abc    &quot;) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String trim(String str) {
		return trim(str, null, 0);
	}

	/**
	 * ��ȥ�ַ���ͷβ����ָ���ַ�������ַ����� <code>null</code> ����Ȼ���� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trim(null, *)          = null
	 *     StringUtil.trim(&quot;&quot;, *)            = &quot;&quot;
	 *     StringUtil.trim(&quot;abc&quot;, null)      = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abc&quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;abc  &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot; abc &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param stripChars
	 *            Ҫ��ȥ���ַ������Ϊ <code>null</code> ��ʾ��ȥ�հ��ַ�
	 * 
	 * @return ��ȥָ���ַ���ĵ��ַ��������ԭ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String trim(String str, String stripChars) {
		return trim(str, stripChars, 0);
	}

	/**
	 * ��ȥ�ַ���ͷ���Ŀհף�����ַ����� <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trimStart(null)         = null
	 *     StringUtil.trimStart(&quot;&quot;)           = &quot;&quot;
	 *     StringUtil.trimStart(&quot;abc&quot;)        = &quot;abc&quot;
	 *     StringUtil.trimStart(&quot;  abc&quot;)      = &quot;abc&quot;
	 *     StringUtil.trimStart(&quot;abc  &quot;)      = &quot;abc  &quot;
	 *     StringUtil.trimStart(&quot; abc &quot;)      = &quot;abc &quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> �����ַ���Ϊ <code>""</code> ���򷵻�
	 *         <code>null</code>
	 */
	public static String trimStart(String str) {
		return trim(str, null, -1);
	}

	/**
	 * ��ȥ�ַ���ͷ����ָ���ַ�������ַ����� <code>null</code> ����Ȼ���� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trimStart(null, *)          = null
	 *     StringUtil.trimStart(&quot;&quot;, *)            = &quot;&quot;
	 *     StringUtil.trimStart(&quot;abc&quot;, &quot;&quot;)        = &quot;abc&quot;
	 *     StringUtil.trimStart(&quot;abc&quot;, null)      = &quot;abc&quot;
	 *     StringUtil.trimStart(&quot;  abc&quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trimStart(&quot;abc  &quot;, null)    = &quot;abc  &quot;
	 *     StringUtil.trimStart(&quot; abc &quot;, null)    = &quot;abc &quot;
	 *     StringUtil.trimStart(&quot;yxabc  &quot;, &quot;xyz&quot;) = &quot;abc  &quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param stripChars
	 *            Ҫ��ȥ���ַ������Ϊ <code>null</code> ��ʾ��ȥ�հ��ַ�
	 * 
	 * @return ��ȥָ���ַ���ĵ��ַ��������ԭ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String trimStart(String str, String stripChars) {
		return trim(str, stripChars, -1);
	}

	/**
	 * ��ȥ�ַ���β���Ŀհף�����ַ����� <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trimEnd(null)       = null
	 *     StringUtil.trimEnd(&quot;&quot;)         = &quot;&quot;
	 *     StringUtil.trimEnd(&quot;abc&quot;)      = &quot;abc&quot;
	 *     StringUtil.trimEnd(&quot;  abc&quot;)    = &quot;  abc&quot;
	 *     StringUtil.trimEnd(&quot;abc  &quot;)    = &quot;abc&quot;
	 *     StringUtil.trimEnd(&quot; abc &quot;)    = &quot; abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> �����ַ���Ϊ <code>""</code> ���򷵻�
	 *         <code>null</code>
	 */
	public static String trimEnd(String str) {
		return trim(str, null, 1);
	}

	/**
	 * ��ȥ�ַ���β����ָ���ַ�������ַ����� <code>null</code> ����Ȼ���� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trimEnd(null, *)          = null
	 *     StringUtil.trimEnd(&quot;&quot;, *)            = &quot;&quot;
	 *     StringUtil.trimEnd(&quot;abc&quot;, &quot;&quot;)        = &quot;abc&quot;
	 *     StringUtil.trimEnd(&quot;abc&quot;, null)      = &quot;abc&quot;
	 *     StringUtil.trimEnd(&quot;  abc&quot;, null)    = &quot;  abc&quot;
	 *     StringUtil.trimEnd(&quot;abc  &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trimEnd(&quot; abc &quot;, null)    = &quot; abc&quot;
	 *     StringUtil.trimEnd(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param stripChars
	 *            Ҫ��ȥ���ַ������Ϊ <code>null</code> ��ʾ��ȥ�հ��ַ�
	 * 
	 * @return ��ȥָ���ַ���ĵ��ַ��������ԭ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String trimEnd(String str, String stripChars) {
		return trim(str, stripChars, 1);
	}

	/**
	 * ��ȥ�ַ���ͷβ���Ŀհף��������ַ����ǿ��ַ��� <code>""</code> ���򷵻� <code>null</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trimToNull(null)          = null
	 *     StringUtil.trimToNull(&quot;&quot;)            = null
	 *     StringUtil.trimToNull(&quot;     &quot;)       = null
	 *     StringUtil.trimToNull(&quot;abc&quot;)         = &quot;abc&quot;
	 *     StringUtil.trimToNull(&quot;    abc    &quot;) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> �����ַ���Ϊ <code>""</code> ���򷵻�
	 *         <code>null</code>
	 */
	public static String trimToNull(String str) {
		return trimToNull(str, null);
	}

	/**
	 * ��ȥ�ַ���ͷβ���Ŀհף��������ַ����ǿ��ַ��� <code>""</code> ���򷵻� <code>null</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trim(null, *)          = null
	 *     StringUtil.trim(&quot;&quot;, *)            = null
	 *     StringUtil.trim(&quot;abc&quot;, null)      = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abc&quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;abc  &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot; abc &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param stripChars
	 *            Ҫ��ȥ���ַ������Ϊ <code>null</code> ��ʾ��ȥ�հ��ַ�
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> �����ַ���Ϊ <code>""</code> ���򷵻�
	 *         <code>null</code>
	 */
	public static String trimToNull(String str, String stripChars) {
		String result = trim(str, stripChars);

		if ((result == null) || (result.length() == 0)) {
			return null;
		}

		return result;
	}

	/**
	 * ��ȥ�ַ���ͷβ���Ŀհף�����ַ����� <code>null</code> ���򷵻ؿ��ַ��� <code>""</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trimToEmpty(null)          = &quot;&quot;
	 *     StringUtil.trimToEmpty(&quot;&quot;)            = &quot;&quot;
	 *     StringUtil.trimToEmpty(&quot;     &quot;)       = &quot;&quot;
	 *     StringUtil.trimToEmpty(&quot;abc&quot;)         = &quot;abc&quot;
	 *     StringUtil.trimToEmpty(&quot;    abc    &quot;) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> �����ַ���Ϊ <code>""</code> ���򷵻�
	 *         <code>null</code>
	 */
	public static String trimToEmpty(String str) {
		return trimToEmpty(str, null);
	}

	/**
	 * ��ȥ�ַ���ͷβ���Ŀհף�����ַ����� <code>null</code> ���򷵻ؿ��ַ��� <code>""</code>��
	 * 
	 * <p>
	 * ע�⣬�� <code>String.trim</code> ��ͬ���˷���ʹ��
	 * <code>Character.isWhitespace</code> ���ж��հף� ������Գ�ȥӢ���ַ���֮��������հף������Ŀո�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trim(null, *)          = &quot;&quot;
	 *     StringUtil.trim(&quot;&quot;, *)            = &quot;&quot;
	 *     StringUtil.trim(&quot;abc&quot;, null)      = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abc&quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;abc  &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot; abc &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ��ȥ�հ׵��ַ��������ԭ�ִ�Ϊ <code>null</code> �����ַ���Ϊ <code>""</code> ���򷵻�
	 *         <code>null</code>
	 */
	public static String trimToEmpty(String str, String stripChars) {
		String result = trim(str, stripChars);

		if (result == null) {
			return EMPTY_STRING;
		}

		return result;
	}

	/**
	 * ��ȥ�ַ���ͷβ����ָ���ַ�������ַ����� <code>null</code> ����Ȼ���� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.trim(null, *)          = null
	 *     StringUtil.trim(&quot;&quot;, *)            = &quot;&quot;
	 *     StringUtil.trim(&quot;abc&quot;, null)      = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abc&quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;abc  &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot; abc &quot;, null)    = &quot;abc&quot;
	 *     StringUtil.trim(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param stripChars
	 *            Ҫ��ȥ���ַ������Ϊ <code>null</code> ��ʾ��ȥ�հ��ַ�
	 * @param mode
	 *            <code>-1</code> ��ʾtrimStart�� <code>0</code> ��ʾtrimȫ����
	 *            <code>1</code> ��ʾtrimEnd
	 * 
	 * @return ��ȥָ���ַ���ĵ��ַ��������ԭ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	private static String trim(String str, String stripChars, int mode) {
		if (str == null) {
			return null;
		}

		int length = str.length();
		int start = 0;
		int end = length;

		// ɨ���ַ���ͷ��
		if (mode <= 0) {
			if (stripChars == null) {
				while ((start < end)
						&& (Character.isWhitespace(str.charAt(start)))) {
					start++;
				}
			} else if (stripChars.length() == 0) {
				return str;
			} else {
				while ((start < end)
						&& (stripChars.indexOf(str.charAt(start)) != -1)) {
					start++;
				}
			}
		}

		// ɨ���ַ���β��
		if (mode >= 0) {
			if (stripChars == null) {
				while ((start < end)
						&& (Character.isWhitespace(str.charAt(end - 1)))) {
					end--;
				}
			} else if (stripChars.length() == 0) {
				return str;
			} else {
				while ((start < end)
						&& (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
					end--;
				}
			}
		}

		if ((start > 0) || (end < length)) {
			return str.substring(start, end);
		}

		return str;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �ȽϺ����� */
	/*                                                                              */
	/* ���·��������Ƚ������ַ����Ƿ���ͬ�� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * �Ƚ������ַ�������Сд���У���
	 * 
	 * <pre>
	 * 
	 *     StringUtil.equals(null, null)   = true
	 *     StringUtil.equals(null, &quot;abc&quot;)  = false
	 *     StringUtil.equals(&quot;abc&quot;, null)  = false
	 *     StringUtil.equals(&quot;abc&quot;, &quot;abc&quot;) = true
	 *     StringUtil.equals(&quot;abc&quot;, &quot;ABC&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str1
	 *            Ҫ�Ƚϵ��ַ���1
	 * @param str2
	 *            Ҫ�Ƚϵ��ַ���2
	 * 
	 * @return ��������ַ�����ͬ�����߶��� <code>null</code> ���򷵻� <code>true</code>
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}

		return str1.equals(str2);
	}

	/**
	 * �Ƚ������ַ�������Сд�����У���
	 * 
	 * <pre>
	 * 
	 *     StringUtil.equalsIgnoreCase(null, null)   = true
	 *     StringUtil.equalsIgnoreCase(null, &quot;abc&quot;)  = false
	 *     StringUtil.equalsIgnoreCase(&quot;abc&quot;, null)  = false
	 *     StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;abc&quot;) = true
	 *     StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;ABC&quot;) = true
	 * 
	 * </pre>
	 * 
	 * @param str1
	 *            Ҫ�Ƚϵ��ַ���1
	 * @param str2
	 *            Ҫ�Ƚϵ��ַ���2
	 * 
	 * @return ��������ַ�����ͬ�����߶��� <code>null</code> ���򷵻� <code>true</code>
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}

		return str1.equalsIgnoreCase(str2);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �ַ��������ж������� */
	/*                                                                              */
	/* �ж��ַ����������Ƿ�Ϊ����ĸ�����֡��հ׵� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode��ĸ��
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isAlpha(null)   = false
	 *     StringUtil.isAlpha(&quot;&quot;)     = true
	 *     StringUtil.isAlpha(&quot;  &quot;)   = false
	 *     StringUtil.isAlpha(&quot;abc&quot;)  = true
	 *     StringUtil.isAlpha(&quot;ab2c&quot;) = false
	 *     StringUtil.isAlpha(&quot;ab-c&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode��ĸ��ɣ��򷵻� <code>true</code>
	 */
	public static boolean isAlpha(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetter(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode��ĸ�Ϳո� <code>' '</code>��
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isAlphaSpace(null)   = false
	 *     StringUtil.isAlphaSpace(&quot;&quot;)     = true
	 *     StringUtil.isAlphaSpace(&quot;  &quot;)   = true
	 *     StringUtil.isAlphaSpace(&quot;abc&quot;)  = true
	 *     StringUtil.isAlphaSpace(&quot;ab c&quot;) = true
	 *     StringUtil.isAlphaSpace(&quot;ab2c&quot;) = false
	 *     StringUtil.isAlphaSpace(&quot;ab-c&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode��ĸ�Ϳո���ɣ��򷵻� <code>true</code>
	 */
	public static boolean isAlphaSpace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetter(str.charAt(i)) && (str.charAt(i) != ' ')) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode��ĸ�����֡�
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isAlphanumeric(null)   = false
	 *     StringUtil.isAlphanumeric(&quot;&quot;)     = true
	 *     StringUtil.isAlphanumeric(&quot;  &quot;)   = false
	 *     StringUtil.isAlphanumeric(&quot;abc&quot;)  = true
	 *     StringUtil.isAlphanumeric(&quot;ab c&quot;) = false
	 *     StringUtil.isAlphanumeric(&quot;ab2c&quot;) = true
	 *     StringUtil.isAlphanumeric(&quot;ab-c&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode��ĸ������ɣ��򷵻� <code>true</code>
	 */
	public static boolean isAlphanumeric(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode��ĸ���ֺͿո� <code>' '</code>��
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isAlphanumericSpace(null)   = false
	 *     StringUtil.isAlphanumericSpace(&quot;&quot;)     = true
	 *     StringUtil.isAlphanumericSpace(&quot;  &quot;)   = true
	 *     StringUtil.isAlphanumericSpace(&quot;abc&quot;)  = true
	 *     StringUtil.isAlphanumericSpace(&quot;ab c&quot;) = true
	 *     StringUtil.isAlphanumericSpace(&quot;ab2c&quot;) = true
	 *     StringUtil.isAlphanumericSpace(&quot;ab-c&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode��ĸ���ֺͿո���ɣ��򷵻�
	 *         <code>true</code>
	 */
	public static boolean isAlphanumericSpace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))
					&& (str.charAt(i) != ' ')) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode���֡�
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isNumeric(null)   = false
	 *     StringUtil.isNumeric(&quot;&quot;)     = true
	 *     StringUtil.isNumeric(&quot;  &quot;)   = false
	 *     StringUtil.isNumeric(&quot;123&quot;)  = true
	 *     StringUtil.isNumeric(&quot;12 3&quot;) = false
	 *     StringUtil.isNumeric(&quot;ab2c&quot;) = false
	 *     StringUtil.isNumeric(&quot;12-3&quot;) = false
	 *     StringUtil.isNumeric(&quot;12.3&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode������ɣ��򷵻� <code>true</code>
	 */
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode���ֺͿո� <code>' '</code>��
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isNumericSpace(null)   = false
	 *     StringUtil.isNumericSpace(&quot;&quot;)     = true
	 *     StringUtil.isNumericSpace(&quot;  &quot;)   = true
	 *     StringUtil.isNumericSpace(&quot;123&quot;)  = true
	 *     StringUtil.isNumericSpace(&quot;12 3&quot;) = true
	 *     StringUtil.isNumericSpace(&quot;ab2c&quot;) = false
	 *     StringUtil.isNumericSpace(&quot;12-3&quot;) = false
	 *     StringUtil.isNumericSpace(&quot;12.3&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode���ֺͿո���ɣ��򷵻� <code>true</code>
	 */
	public static boolean isNumericSpace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i)) && (str.charAt(i) != ' ')) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�ֻ����unicode�հס�
	 * 
	 * <p>
	 * <code>null</code> ������ <code>false</code> �����ַ��� <code>""</code> ������
	 * <code>true</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.isWhitespace(null)   = false
	 *     StringUtil.isWhitespace(&quot;&quot;)     = true
	 *     StringUtil.isWhitespace(&quot;  &quot;)   = true
	 *     StringUtil.isWhitespace(&quot;abc&quot;)  = false
	 *     StringUtil.isWhitespace(&quot;ab2c&quot;) = false
	 *     StringUtil.isWhitespace(&quot;ab-c&quot;) = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * 
	 * @return ����ַ����� <code>null</code> ����ȫ��unicode�հ���ɣ��򷵻� <code>true</code>
	 */
	public static boolean isWhitespace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ��Сдת���� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ���ַ���ת���ɴ�д��
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.toUpperCase(null)  = null
	 *     StringUtil.toUpperCase(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.toUpperCase(&quot;aBc&quot;) = &quot;ABC&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return ��д�ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String toUpperCase(String str) {
		if (str == null) {
			return null;
		}

		return str.toUpperCase();
	}

	/**
	 * ���ַ���ת����Сд��
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.toLowerCase(null)  = null
	 *     StringUtil.toLowerCase(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.toLowerCase(&quot;aBc&quot;) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return ��д�ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String toLowerCase(String str) {
		if (str == null) {
			return null;
		}

		return str.toLowerCase();
	}

	/**
	 * ���ַ��������ַ�ת�ɴ�д�� <code>Character.toTitleCase</code> ���������ַ����䡣
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.capitalize(null)  = null
	 *     StringUtil.capitalize(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.capitalize(&quot;cat&quot;) = &quot;Cat&quot;
	 *     StringUtil.capitalize(&quot;cAt&quot;) = &quot;CAt&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return ���ַ�Ϊ��д���ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String capitalize(String str) {
		int strLen;

		if ((str == null) || ((strLen = str.length()) == 0)) {
			return str;
		}

		return new StringBuffer(strLen)
				.append(Character.toTitleCase(str.charAt(0)))
				.append(str.substring(1)).toString();
	}

	/**
	 * ���ַ��������ַ�ת��Сд�������ַ����䡣
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.uncapitalize(null)  = null
	 *     StringUtil.uncapitalize(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.uncapitalize(&quot;Cat&quot;) = &quot;cat&quot;
	 *     StringUtil.uncapitalize(&quot;CAT&quot;) = &quot;cAT&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return ���ַ�ΪСд���ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String uncapitalize(String str) {
		int strLen;

		if ((str == null) || ((strLen = str.length()) == 0)) {
			return str;
		}

		return new StringBuffer(strLen)
				.append(Character.toLowerCase(str.charAt(0)))
				.append(str.substring(1)).toString();
	}

	/**
	 * ��ת�ַ����Ĵ�Сд��
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.swapCase(null)                 = null
	 *     StringUtil.swapCase(&quot;&quot;)                   = &quot;&quot;
	 *     StringUtil.swapCase(&quot;The dog has a BONE&quot;) = &quot;tHE DOG HAS A bone&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return ��Сд����ת���ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String swapCase(String str) {
		int strLen;

		if ((str == null) || ((strLen = str.length()) == 0)) {
			return str;
		}

		StringBuffer buffer = new StringBuffer(strLen);

		char ch = 0;

		for (int i = 0; i < strLen; i++) {
			ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {
				ch = Character.toLowerCase(ch);
			} else if (Character.isTitleCase(ch)) {
				ch = Character.toLowerCase(ch);
			} else if (Character.isLowerCase(ch)) {
				ch = Character.toUpperCase(ch);
			}

			buffer.append(ch);
		}

		return buffer.toString();
	}

	/**
	 * ���ַ���ת����camel case��
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.toCamelCase(null)  = null
	 *     StringUtil.toCamelCase(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.toCamelCase(&quot;aBc&quot;) = &quot;aBc&quot;
	 *     StringUtil.toCamelCase(&quot;aBc def&quot;) = &quot;aBcDef&quot;
	 *     StringUtil.toCamelCase(&quot;aBc def_ghi&quot;) = &quot;aBcDefGhi&quot;
	 *     StringUtil.toCamelCase(&quot;aBc def_ghi 123&quot;) = &quot;aBcDefGhi123&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * <p>
	 * �˷����ᱣ�������»��ߺͿհ���������зָ�����
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return camel case�ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String toCamelCase(String str) {
		return CAMEL_CASE_TOKENIZER.parse(str);
	}

	/**
	 * ���ַ���ת����pascal case��
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.toPascalCase(null)  = null
	 *     StringUtil.toPascalCase(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.toPascalCase(&quot;aBc&quot;) = &quot;ABc&quot;
	 *     StringUtil.toPascalCase(&quot;aBc def&quot;) = &quot;ABcDef&quot;
	 *     StringUtil.toPascalCase(&quot;aBc def_ghi&quot;) = &quot;ABcDefGhi&quot;
	 *     StringUtil.toPascalCase(&quot;aBc def_ghi 123&quot;) = &quot;aBcDefGhi123&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * <p>
	 * �˷����ᱣ�������»��ߺͿհ���������зָ�����
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return pascal case�ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String toPascalCase(String str) {
		return PASCAL_CASE_TOKENIZER.parse(str);
	}

	/**
	 * ���ַ���ת�����»��߷ָ��Ĵ�д�ַ�����
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.toUpperCaseWithUnderscores(null)  = null
	 *     StringUtil.toUpperCaseWithUnderscores(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.toUpperCaseWithUnderscores(&quot;aBc&quot;) = &quot;A_BC&quot;
	 *     StringUtil.toUpperCaseWithUnderscores(&quot;aBc def&quot;) = &quot;A_BC_DEF&quot;
	 *     StringUtil.toUpperCaseWithUnderscores(&quot;aBc def_ghi&quot;) = &quot;A_BC_DEF_GHI&quot;
	 *     StringUtil.toUpperCaseWithUnderscores(&quot;aBc def_ghi 123&quot;) = &quot;A_BC_DEF_GHI_123&quot;
	 *     StringUtil.toUpperCaseWithUnderscores(&quot;__a__Bc__&quot;) = &quot;__A__BC__&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * <p>
	 * �˷����ᱣ�����˿հ���������зָ�����
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return �»��߷ָ��Ĵ�д�ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String toUpperCaseWithUnderscores(String str) {
		return UPPER_CASE_WITH_UNDERSCORES_TOKENIZER.parse(str);
	}

	/**
	 * ���ַ���ת�����»��߷ָ���Сд�ַ�����
	 * 
	 * <p>
	 * ����ַ����� <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.toLowerCaseWithUnderscores(null)  = null
	 *     StringUtil.toLowerCaseWithUnderscores(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.toLowerCaseWithUnderscores(&quot;aBc&quot;) = &quot;a_bc&quot;
	 *     StringUtil.toLowerCaseWithUnderscores(&quot;aBc def&quot;) = &quot;a_bc_def&quot;
	 *     StringUtil.toLowerCaseWithUnderscores(&quot;aBc def_ghi&quot;) = &quot;a_bc_def_ghi&quot;
	 *     StringUtil.toLowerCaseWithUnderscores(&quot;aBc def_ghi 123&quot;) = &quot;a_bc_def_ghi_123&quot;
	 *     StringUtil.toLowerCaseWithUnderscores(&quot;__a__Bc__&quot;) = &quot;__a__bc__&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * <p>
	 * �˷����ᱣ�����˿հ���������зָ�����
	 * </p>
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * 
	 * @return �»��߷ָ���Сд�ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String toLowerCaseWithUnderscores(String str) {
		return LOWER_CASE_WITH_UNDERSCORES_TOKENIZER.parse(str);
	}

	/** �������ʵĽ������� */
	private static final WordTokenizer CAMEL_CASE_TOKENIZER = new WordTokenizer() {
		protected void startSentence(StringBuffer buffer, char ch) {
			buffer.append(Character.toLowerCase(ch));
		}

		protected void startWord(StringBuffer buffer, char ch) {
			if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
				buffer.append(Character.toUpperCase(ch));
			} else {
				buffer.append(Character.toLowerCase(ch));
			}
		}

		protected void inWord(StringBuffer buffer, char ch) {
			buffer.append(Character.toLowerCase(ch));
		}

		protected void startDigitSentence(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void startDigitWord(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void inDigitWord(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void inDelimiter(StringBuffer buffer, char ch) {
			if (ch != UNDERSCORE) {
				buffer.append(ch);
			}
		}
	};

	private static final WordTokenizer PASCAL_CASE_TOKENIZER = new WordTokenizer() {
		protected void startSentence(StringBuffer buffer, char ch) {
			buffer.append(Character.toUpperCase(ch));
		}

		protected void startWord(StringBuffer buffer, char ch) {
			buffer.append(Character.toUpperCase(ch));
		}

		protected void inWord(StringBuffer buffer, char ch) {
			buffer.append(Character.toLowerCase(ch));
		}

		protected void startDigitSentence(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void startDigitWord(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void inDigitWord(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void inDelimiter(StringBuffer buffer, char ch) {
			if (ch != UNDERSCORE) {
				buffer.append(ch);
			}
		}
	};

	private static final WordTokenizer UPPER_CASE_WITH_UNDERSCORES_TOKENIZER = new WordTokenizer() {
		protected void startSentence(StringBuffer buffer, char ch) {
			buffer.append(Character.toUpperCase(ch));
		}

		protected void startWord(StringBuffer buffer, char ch) {
			if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
				buffer.append(UNDERSCORE);
			}

			buffer.append(Character.toUpperCase(ch));
		}

		protected void inWord(StringBuffer buffer, char ch) {
			buffer.append(Character.toUpperCase(ch));
		}

		protected void startDigitSentence(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void startDigitWord(StringBuffer buffer, char ch) {
			if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
				buffer.append(UNDERSCORE);
			}

			buffer.append(ch);
		}

		protected void inDigitWord(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void inDelimiter(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}
	};

	private static final WordTokenizer LOWER_CASE_WITH_UNDERSCORES_TOKENIZER = new WordTokenizer() {
		protected void startSentence(StringBuffer buffer, char ch) {
			buffer.append(Character.toLowerCase(ch));
		}

		protected void startWord(StringBuffer buffer, char ch) {
			if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
				buffer.append(UNDERSCORE);
			}

			buffer.append(Character.toLowerCase(ch));
		}

		protected void inWord(StringBuffer buffer, char ch) {
			buffer.append(Character.toLowerCase(ch));
		}

		protected void startDigitSentence(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void startDigitWord(StringBuffer buffer, char ch) {
			if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
				buffer.append(UNDERSCORE);
			}

			buffer.append(ch);
		}

		protected void inDigitWord(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}

		protected void inDelimiter(StringBuffer buffer, char ch) {
			buffer.append(ch);
		}
	};

	/**
	 * �����������﷨�����ɵ� <code>SENTENCE</code>��
	 * 
	 * <pre>
	 * 
	 *      SENTENCE = WORD (DELIMITER* WORD)*
	 *     
	 *      WORD = UPPER_CASE_WORD | LOWER_CASE_WORD | TITLE_CASE_WORD | DIGIT_WORD
	 *     
	 *      UPPER_CASE_WORD = UPPER_CASE_LETTER+
	 *      LOWER_CASE_WORD = LOWER_CASE_LETTER+
	 *      TITLE_CASE_WORD = UPPER_CASE_LETTER LOWER_CASE_LETTER+
	 *      DIGIT_WORD      = DIGIT+
	 *     
	 *      UPPER_CASE_LETTER = Character.isUpperCase()
	 *      LOWER_CASE_LETTER = Character.isLowerCase()
	 *      DIGIT             = Character.isDigit()
	 *      NON_LETTER_DIGIT  = !Character.isUpperCase() &amp;&amp; !Character.isLowerCase() &amp;&amp; !Character.isDigit()
	 *     
	 *      DELIMITER = WHITESPACE | NON_LETTER_DIGIT
	 * 
	 * </pre>
	 */
	private abstract static class WordTokenizer {
		protected static final char UNDERSCORE = '_';

		/**
		 * Parse sentence��
		 */
		public String parse(String str) {
			if (StringUtils.isEmpty(str)) {
				return str;
			}

			int length = str.length();
			StringBuffer buffer = new StringBuffer(length);

			for (int index = 0; index < length; index++) {
				char ch = str.charAt(index);

				// ���Կհס�
				if (Character.isWhitespace(ch)) {
					continue;
				}

				// ��д��ĸ��ʼ��UpperCaseWord����TitleCaseWord��
				if (Character.isUpperCase(ch)) {
					int wordIndex = index + 1;

					while (wordIndex < length) {
						char wordChar = str.charAt(wordIndex);

						if (Character.isUpperCase(wordChar)) {
							wordIndex++;
						} else if (Character.isLowerCase(wordChar)) {
							wordIndex--;
							break;
						} else {
							break;
						}
					}

					// 1. wordIndex == length��˵�����һ����ĸΪ��д����upperCaseWord����֮��
					// 2. wordIndex == index��˵��index��Ϊһ��titleCaseWord��
					// 3. wordIndex > index��˵��index��wordIndex -
					// 1��ȫ���Ǵ�д����upperCaseWord����
					if ((wordIndex == length) || (wordIndex > index)) {
						index = parseUpperCaseWord(buffer, str, index,
								wordIndex);
					} else {
						index = parseTitleCaseWord(buffer, str, index);
					}

					continue;
				}

				// Сд��ĸ��ʼ��LowerCaseWord��
				if (Character.isLowerCase(ch)) {
					index = parseLowerCaseWord(buffer, str, index);
					continue;
				}

				// ���ֿ�ʼ��DigitWord��
				if (Character.isDigit(ch)) {
					index = parseDigitWord(buffer, str, index);
					continue;
				}

				// ����ĸ���ֿ�ʼ��Delimiter��
				inDelimiter(buffer, ch);
			}

			return buffer.toString();
		}

		private int parseUpperCaseWord(StringBuffer buffer, String str,
				int index, int length) {
			char ch = str.charAt(index++);

			// ����ĸ����Ȼ������Ϊ��д��
			if (buffer.length() == 0) {
				startSentence(buffer, ch);
			} else {
				startWord(buffer, ch);
			}

			// ������ĸ����ΪСд��
			for (; index < length; index++) {
				ch = str.charAt(index);
				inWord(buffer, ch);
			}

			return index - 1;
		}

		private int parseLowerCaseWord(StringBuffer buffer, String str,
				int index) {
			char ch = str.charAt(index++);

			// ����ĸ����Ȼ������ΪСд��
			if (buffer.length() == 0) {
				startSentence(buffer, ch);
			} else {
				startWord(buffer, ch);
			}

			// ������ĸ����ΪСд��
			int length = str.length();

			for (; index < length; index++) {
				ch = str.charAt(index);

				if (Character.isLowerCase(ch)) {
					inWord(buffer, ch);
				} else {
					break;
				}
			}

			return index - 1;
		}

		private int parseTitleCaseWord(StringBuffer buffer, String str,
				int index) {
			char ch = str.charAt(index++);

			// ����ĸ����Ȼ������Ϊ��д��
			if (buffer.length() == 0) {
				startSentence(buffer, ch);
			} else {
				startWord(buffer, ch);
			}

			// ������ĸ����ΪСд��
			int length = str.length();

			for (; index < length; index++) {
				ch = str.charAt(index);

				if (Character.isLowerCase(ch)) {
					inWord(buffer, ch);
				} else {
					break;
				}
			}

			return index - 1;
		}

		private int parseDigitWord(StringBuffer buffer, String str, int index) {
			char ch = str.charAt(index++);

			// ���ַ�����Ȼ������Ϊ���֡�
			if (buffer.length() == 0) {
				startDigitSentence(buffer, ch);
			} else {
				startDigitWord(buffer, ch);
			}

			// �����ַ�����Ϊ���֡�
			int length = str.length();

			for (; index < length; index++) {
				ch = str.charAt(index);

				if (Character.isDigit(ch)) {
					inDigitWord(buffer, ch);
				} else {
					break;
				}
			}

			return index - 1;
		}

		protected boolean isDelimiter(char ch) {
			return !Character.isUpperCase(ch) && !Character.isLowerCase(ch)
					&& !Character.isDigit(ch);
		}

		protected abstract void startSentence(StringBuffer buffer, char ch);

		protected abstract void startWord(StringBuffer buffer, char ch);

		protected abstract void inWord(StringBuffer buffer, char ch);

		protected abstract void startDigitSentence(StringBuffer buffer, char ch);

		protected abstract void startDigitWord(StringBuffer buffer, char ch);

		protected abstract void inDigitWord(StringBuffer buffer, char ch);

		protected abstract void inDelimiter(StringBuffer buffer, char ch);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �ַ����ָ���� */
	/*                                                                              */
	/* ���ַ�����ָ���ָ����ָ */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ���ַ������հ��ַ��ָ
	 * 
	 * <p>
	 * �ָ������������Ŀ�������У������ķָ����ͱ�����һ��������ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.split(null)       = null
	 *     StringUtil.split(&quot;&quot;)         = []
	 *     StringUtil.split(&quot;abc def&quot;)  = [&quot;abc&quot;, &quot;def&quot;]
	 *     StringUtil.split(&quot;abc  def&quot;) = [&quot;abc&quot;, &quot;def&quot;]
	 *     StringUtil.split(&quot; abc &quot;)    = [&quot;abc&quot;]
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ�ָ���ַ���
	 * 
	 * @return �ָ����ַ������飬���ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String[] split(String str) {
		return split(str, null, -1);
	}

	/**
	 * ���ַ�����ָ���ַ��ָ
	 * 
	 * <p>
	 * �ָ������������Ŀ�������У������ķָ����ͱ�����һ��������ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.split(null, *)         = null
	 *     StringUtil.split(&quot;&quot;, *)           = []
	 *     StringUtil.split(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
	 *     StringUtil.split(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
	 *     StringUtil.split(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
	 *     StringUtil.split(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ�ָ���ַ���
	 * @param separatorChar
	 *            �ָ���
	 * 
	 * @return �ָ����ַ������飬���ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String[] split(String str, char separatorChar) {
		if (str == null) {
			return null;
		}

		int length = str.length();

		if (length == 0) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		int i = 0;
		int start = 0;
		boolean match = false;

		while (i < length) {
			if (str.charAt(i) == separatorChar) {
				if (match) {
					list.add(str.substring(start, i));
					match = false;
				}

				start = ++i;
				continue;
			}

			match = true;
			i++;
		}

		if (match) {
			list.add(str.substring(start, i));
		}

		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * ���ַ�����ָ���ַ��ָ
	 * 
	 * <p>
	 * �ָ������������Ŀ�������У������ķָ����ͱ�����һ��������ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.split(null, *)                = null
	 *     StringUtil.split(&quot;&quot;, *)                  = []
	 *     StringUtil.split(&quot;abc def&quot;, null)        = [&quot;abc&quot;, &quot;def&quot;]
	 *     StringUtil.split(&quot;abc def&quot;, &quot; &quot;)         = [&quot;abc&quot;, &quot;def&quot;]
	 *     StringUtil.split(&quot;abc  def&quot;, &quot; &quot;)        = [&quot;abc&quot;, &quot;def&quot;]
	 *     StringUtil.split(&quot; ab:  cd::ef  &quot;, &quot;:&quot;)  = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
	 *     StringUtil.split(&quot;abc.def&quot;, &quot;&quot;)          = [&quot;abc.def&quot;]
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ�ָ���ַ���
	 * @param separatorChars
	 *            �ָ���
	 * 
	 * @return �ָ����ַ������飬���ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String[] split(String str, String separatorChars) {
		return split(str, separatorChars, -1);
	}

	/**
	 * ���ַ�����ָ���ַ��ָ
	 * 
	 * <p>
	 * �ָ������������Ŀ�������У������ķָ����ͱ�����һ��������ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.split(null, *, *)                 = null
	 *     StringUtil.split(&quot;&quot;, *, *)                   = []
	 *     StringUtil.split(&quot;ab cd ef&quot;, null, 0)        = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
	 *     StringUtil.split(&quot;  ab   cd ef  &quot;, null, 0)  = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
	 *     StringUtil.split(&quot;ab:cd::ef&quot;, &quot;:&quot;, 0)        = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
	 *     StringUtil.split(&quot;ab:cd:ef&quot;, &quot;:&quot;, 2)         = [&quot;ab&quot;, &quot;cdef&quot;]
	 *     StringUtil.split(&quot;abc.def&quot;, &quot;&quot;, 2)           = [&quot;abc.def&quot;]
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ�ָ���ַ���
	 * @param separatorChars
	 *            �ָ���
	 * @param max
	 *            ���ص�����������������С�ڵ���0�����ʾ������
	 * 
	 * @return �ָ����ַ������飬���ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String[] split(String str, String separatorChars, int max) {
		if (str == null) {
			return null;
		}

		int length = str.length();

		if (length == 0) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		int sizePlus1 = 1;
		int i = 0;
		int start = 0;
		boolean match = false;

		if (separatorChars == null) {
			// null��ʾʹ�ÿհ���Ϊ�ָ���
			while (i < length) {
				if (Character.isWhitespace(str.charAt(i))) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		} else if (separatorChars.length() == 1) {
			// �Ż��ָ�������Ϊ1������
			char sep = separatorChars.charAt(0);

			while (i < length) {
				if (str.charAt(i) == sep) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		} else {
			// һ������
			while (i < length) {
				if (separatorChars.indexOf(str.charAt(i)) >= 0) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		}

		if (match) {
			list.add(str.substring(start, i));
		}

		return (String[]) list.toArray(new String[list.size()]);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �ַ������Ӻ����� */
	/*                                                                              */
	/* ���������ָ���ָ������ӳ��ַ����� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * �������е�Ԫ�����ӳ�һ���ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.join(null)            = null
	 *     StringUtil.join([])              = &quot;&quot;
	 *     StringUtil.join([null])          = &quot;&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]) = &quot;abc&quot;
	 *     StringUtil.join([null, &quot;&quot;, &quot;a&quot;]) = &quot;a&quot;
	 * 
	 * </pre>
	 * 
	 * @param array
	 *            Ҫ���ӵ�����
	 * 
	 * @return ���Ӻ���ַ��������ԭ����Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String join(Object[] array) {
		return join(array, null);
	}

	/**
	 * �������е�Ԫ�����ӳ�һ���ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.join(null, *)               = null
	 *     StringUtil.join([], *)                 = &quot;&quot;
	 *     StringUtil.join([null], *)             = &quot;&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], ';')  = &quot;a;b;c&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null) = &quot;abc&quot;
	 *     StringUtil.join([null, &quot;&quot;, &quot;a&quot;], ';')  = &quot;;;a&quot;
	 * 
	 * </pre>
	 * 
	 * @param array
	 *            Ҫ���ӵ�����
	 * @param separator
	 *            �ָ���
	 * 
	 * @return ���Ӻ���ַ��������ԭ����Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String join(Object[] array, char separator) {
		if (array == null) {
			return null;
		}

		int arraySize = array.length;
		int bufSize = (arraySize == 0) ? 0 : ((((array[0] == null) ? 16
				: array[0].toString().length()) + 1) * arraySize);
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if (i > 0) {
				buf.append(separator);
			}

			if (array[i] != null) {
				buf.append(array[i]);
			}
		}

		return buf.toString();
	}

	/**
	 * �������е�Ԫ�����ӳ�һ���ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.join(null, *)                = null
	 *     StringUtil.join([], *)                  = &quot;&quot;
	 *     StringUtil.join([null], *)              = &quot;&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;--&quot;)  = &quot;a--b--c&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null)  = &quot;abc&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;&quot;)    = &quot;abc&quot;
	 *     StringUtil.join([null, &quot;&quot;, &quot;a&quot;], ',')   = &quot;,,a&quot;
	 * 
	 * </pre>
	 * 
	 * @param array
	 *            Ҫ���ӵ�����
	 * @param separator
	 *            �ָ���
	 * 
	 * @return ���Ӻ���ַ��������ԭ����Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String join(Object[] array, String separator) {
		if (array == null) {
			return null;
		}

		if (separator == null) {
			separator = EMPTY_STRING;
		}

		int arraySize = array.length;

		// ArraySize == 0: Len = 0
		// ArraySize > 0: Len = NofStrings *(len(firstString) + len(separator))
		// (���ƴ�Լ���е��ַ�����һ����)
		int bufSize = (arraySize == 0) ? 0
				: (arraySize * (((array[0] == null) ? 16 : array[0].toString()
						.length()) + ((separator != null) ? separator.length()
						: 0)));

		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if ((separator != null) && (i > 0)) {
				buf.append(separator);
			}

			if (array[i] != null) {
				buf.append(array[i]);
			}
		}

		return buf.toString();
	}

	/**
	 * �� <code>Iterator</code> �е�Ԫ�����ӳ�һ���ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.join(null, *)                = null
	 *     StringUtil.join([], *)                  = &quot;&quot;
	 *     StringUtil.join([null], *)              = &quot;&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;--&quot;)  = &quot;a--b--c&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null)  = &quot;abc&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;&quot;)    = &quot;abc&quot;
	 *     StringUtil.join([null, &quot;&quot;, &quot;a&quot;], ',')   = &quot;,,a&quot;
	 * 
	 * </pre>
	 * 
	 * @param iterator
	 *            Ҫ���ӵ� <code>Iterator</code>
	 * @param separator
	 *            �ָ���
	 * 
	 * @return ���Ӻ���ַ��������ԭ����Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String join(Iterator iterator, char separator) {
		if (iterator == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer(256); // JavaĬ��ֵ��16, ����ƫС

		while (iterator.hasNext()) {
			Object obj = iterator.next();

			if (obj != null) {
				buf.append(obj);
			}

			if (iterator.hasNext()) {
				buf.append(separator);
			}
		}

		return buf.toString();
	}

	/**
	 * �� <code>Iterator</code> �е�Ԫ�����ӳ�һ���ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.join(null, *)                = null
	 *     StringUtil.join([], *)                  = &quot;&quot;
	 *     StringUtil.join([null], *)              = &quot;&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;--&quot;)  = &quot;a--b--c&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null)  = &quot;abc&quot;
	 *     StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;&quot;)    = &quot;abc&quot;
	 *     StringUtil.join([null, &quot;&quot;, &quot;a&quot;], ',')   = &quot;,,a&quot;
	 * 
	 * </pre>
	 * 
	 * @param iterator
	 *            Ҫ���ӵ� <code>Iterator</code>
	 * @param separator
	 *            �ָ���
	 * 
	 * @return ���Ӻ���ַ��������ԭ����Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String join(Iterator iterator, String separator) {
		if (iterator == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer(256); // JavaĬ��ֵ��16, ����ƫС

		while (iterator.hasNext()) {
			Object obj = iterator.next();

			if (obj != null) {
				buf.append(obj);
			}

			if ((separator != null) && iterator.hasNext()) {
				buf.append(separator);
			}
		}

		return buf.toString();
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �ַ������Һ��� ���� �ַ����ַ����� */
	/*                                                                              */
	/* ���ַ����в���ָ���ַ����ַ����� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ���ַ����в���ָ���ַ��������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOf(null, *)         = -1
	 *     StringUtil.indexOf(&quot;&quot;, *)           = -1
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, 'a') = 0
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, 'b') = 2
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChar
	 *            Ҫ���ҵ��ַ�
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOf(String str, char searchChar) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.indexOf(searchChar);
	}

	/**
	 * ���ַ����в���ָ���ַ��������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOf(null, *, *)          = -1
	 *     StringUtil.indexOf(&quot;&quot;, *, *)            = -1
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 0)  = 2
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 3)  = 5
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 9)  = -1
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', -1) = 2
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChar
	 *            Ҫ���ҵ��ַ�
	 * @param startPos
	 *            ��ʼ����������ֵ�����С��0������0
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOf(String str, char searchChar, int startPos) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.indexOf(searchChar, startPos);
	}

	/**
	 * ���ַ����в���ָ���ַ����������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOf(null, *)          = -1
	 *     StringUtil.indexOf(*, null)          = -1
	 *     StringUtil.indexOf(&quot;&quot;, &quot;&quot;)           = 0
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;)  = 0
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;)  = 2
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;) = 1
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;&quot;)   = 0
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStr
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOf(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		return str.indexOf(searchStr);
	}

	/**
	 * ���ַ����в���ָ���ַ����������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOf(null, *, *)          = -1
	 *     StringUtil.indexOf(*, null, *)          = -1
	 *     StringUtil.indexOf(&quot;&quot;, &quot;&quot;, 0)           = 0
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = 2
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 0) = 1
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 3)  = 5
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = -1
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = 2
	 *     StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;&quot;, 2)   = 2
	 *     StringUtil.indexOf(&quot;abc&quot;, &quot;&quot;, 9)        = 3
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStr
	 *            Ҫ���ҵ��ַ���
	 * @param startPos
	 *            ��ʼ����������ֵ�����С��0������0
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOf(String str, String searchStr, int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		// JDK1.3�����°汾��bug��������ȷ������������
		if ((searchStr.length() == 0) && (startPos >= str.length())) {
			return str.length();
		}

		return str.indexOf(searchStr, startPos);
	}

	/**
	 * ���ַ����в���ָ���ַ������е��ַ��������ص�һ��ƥ�����ʼ������ ����ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>-1</code>�� ����ַ�����Ϊ <code>null</code> ��գ�Ҳ���� <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOfAny(null, *)                = -1
	 *     StringUtil.indexOfAny(&quot;&quot;, *)                  = -1
	 *     StringUtil.indexOfAny(*, null)                = -1
	 *     StringUtil.indexOfAny(*, [])                  = -1
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;,['z','a']) = 0
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;,['b','y']) = 3
	 *     StringUtil.indexOfAny(&quot;aba&quot;, ['z'])           = -1
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChars
	 *            Ҫ�������ַ�����
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOfAny(String str, char[] searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length == 0)) {
			return -1;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			for (int j = 0; j < searchChars.length; j++) {
				if (searchChars[j] == ch) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * ���ַ����в���ָ���ַ������е��ַ��������ص�һ��ƥ�����ʼ������ ����ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>-1</code>�� ����ַ�����Ϊ <code>null</code> ��գ�Ҳ���� <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOfAny(null, *)            = -1
	 *     StringUtil.indexOfAny(&quot;&quot;, *)              = -1
	 *     StringUtil.indexOfAny(*, null)            = -1
	 *     StringUtil.indexOfAny(*, &quot;&quot;)              = -1
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, &quot;za&quot;) = 0
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, &quot;by&quot;) = 3
	 *     StringUtil.indexOfAny(&quot;aba&quot;,&quot;z&quot;)          = -1
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChars
	 *            Ҫ�������ַ�����
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOfAny(String str, String searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length() == 0)) {
			return -1;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			for (int j = 0; j < searchChars.length(); j++) {
				if (searchChars.charAt(j) == ch) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * ���ַ����в���ָ���ַ��������е��ַ����������ص�һ��ƥ�����ʼ������ ����ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>-1</code>�� ����ַ�������Ϊ <code>null</code> ��գ�Ҳ���� <code>-1</code>��
	 * ����ַ������ϰ��� <code>""</code> �������ַ�����Ϊ <code>null</code> ���򷵻�
	 * <code>str.length()</code>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOfAny(null, *)                     = -1
	 *     StringUtil.indexOfAny(*, null)                     = -1
	 *     StringUtil.indexOfAny(*, [])                       = -1
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;ab&quot;,&quot;cd&quot;])   = 2
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;cd&quot;,&quot;ab&quot;])   = 2
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;])   = -1
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;zab&quot;,&quot;aby&quot;]) = 1
	 *     StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;&quot;])          = 0
	 *     StringUtil.indexOfAny(&quot;&quot;, [&quot;&quot;])                    = 0
	 *     StringUtil.indexOfAny(&quot;&quot;, [&quot;a&quot;])                   = -1
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStrs
	 *            Ҫ�������ַ�������
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOfAny(String str, String[] searchStrs) {
		if ((str == null) || (searchStrs == null)) {
			return -1;
		}

		int sz = searchStrs.length;

		// String's can't have a MAX_VALUEth index.
		int ret = Integer.MAX_VALUE;

		int tmp = 0;

		for (int i = 0; i < sz; i++) {
			String search = searchStrs[i];

			if (search == null) {
				continue;
			}

			tmp = str.indexOf(search);

			if (tmp == -1) {
				continue;
			}

			if (tmp < ret) {
				ret = tmp;
			}
		}

		return (ret == Integer.MAX_VALUE) ? (-1) : ret;
	}

	/**
	 * ���ַ����в��Ҳ���ָ���ַ������е��ַ��������ص�һ��ƥ�����ʼ������ ����ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>-1</code>�� ����ַ�����Ϊ <code>null</code> ��գ�Ҳ���� <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOfAnyBut(null, *)             = -1
	 *     StringUtil.indexOfAnyBut(&quot;&quot;, *)               = -1
	 *     StringUtil.indexOfAnyBut(*, null)             = -1
	 *     StringUtil.indexOfAnyBut(*, [])               = -1
	 *     StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;,'za')   = 3
	 *     StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;, 'by')  = 0
	 *     StringUtil.indexOfAnyBut(&quot;aba&quot;, 'ab')         = -1
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChars
	 *            Ҫ�������ַ�����
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOfAnyBut(String str, char[] searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length == 0)) {
			return -1;
		}

		outer: for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			for (int j = 0; j < searchChars.length; j++) {
				if (searchChars[j] == ch) {
					continue outer;
				}
			}

			return i;
		}

		return -1;
	}

	/**
	 * ���ַ����в��Ҳ���ָ���ַ������е��ַ��������ص�һ��ƥ�����ʼ������ ����ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>-1</code>�� ����ַ�����Ϊ <code>null</code> ��գ�Ҳ���� <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOfAnyBut(null, *)            = -1
	 *     StringUtil.indexOfAnyBut(&quot;&quot;, *)              = -1
	 *     StringUtil.indexOfAnyBut(*, null)            = -1
	 *     StringUtil.indexOfAnyBut(*, &quot;&quot;)              = -1
	 *     StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;, &quot;za&quot;) = 3
	 *     StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;, &quot;by&quot;) = 0
	 *     StringUtil.indexOfAnyBut(&quot;aba&quot;,&quot;ab&quot;)         = -1
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChars
	 *            Ҫ�������ַ�����
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int indexOfAnyBut(String str, String searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length() == 0)) {
			return -1;
		}

		for (int i = 0; i < str.length(); i++) {
			if (searchChars.indexOf(str.charAt(i)) < 0) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * ���ַ���β����ʼ����ָ���ַ��������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.lastIndexOf(null, *)         = -1
	 *     StringUtil.lastIndexOf(&quot;&quot;, *)           = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'a') = 7
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b') = 5
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChar
	 *            Ҫ���ҵ��ַ�
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int lastIndexOf(String str, char searchChar) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.lastIndexOf(searchChar);
	}

	/**
	 * ���ַ���β����ʼ����ָ���ַ��������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.lastIndexOf(null, *, *)          = -1
	 *     StringUtil.lastIndexOf(&quot;&quot;, *,  *)           = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 8)  = 5
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 4)  = 2
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 0)  = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 9)  = 5
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', -1) = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'a', 0)  = 0
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChar
	 *            Ҫ���ҵ��ַ�
	 * @param startPos
	 *            ��ָ��������ʼ��ǰ����
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int lastIndexOf(String str, char searchChar, int startPos) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.lastIndexOf(searchChar, startPos);
	}

	/**
	 * ���ַ���β����ʼ����ָ���ַ����������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.lastIndexOf(null, *)         = -1
	 *     StringUtil.lastIndexOf(&quot;&quot;, *)           = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'a') = 7
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b') = 5
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStr
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int lastIndexOf(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		return str.lastIndexOf(searchStr);
	}

	/**
	 * ���ַ���β����ʼ����ָ���ַ����������ص�һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻�
	 * <code>-1</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.lastIndexOf(null, *, *)          = -1
	 *     StringUtil.lastIndexOf(*, null, *)          = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 8)  = 7
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 8)  = 5
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 8) = 4
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = 5
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = -1
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
	 *     StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = -1
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStr
	 *            Ҫ���ҵ��ַ���
	 * @param startPos
	 *            ��ָ��������ʼ��ǰ����
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int lastIndexOf(String str, String searchStr, int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		return str.lastIndexOf(searchStr, startPos);
	}

	/**
	 * ���ַ���β����ʼ����ָ���ַ��������е��ַ����������ص�һ��ƥ�����ʼ������ ����ַ���Ϊ <code>null</code> ���򷵻�
	 * <code>-1</code>�� ����ַ�������Ϊ <code>null</code> ��գ�Ҳ���� <code>-1</code>��
	 * ����ַ������ϰ��� <code>""</code> �������ַ�����Ϊ <code>null</code> ���򷵻�
	 * <code>str.length()</code>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.lastIndexOfAny(null, *)                   = -1
	 *     StringUtil.lastIndexOfAny(*, null)                   = -1
	 *     StringUtil.lastIndexOfAny(*, [])                     = -1
	 *     StringUtil.lastIndexOfAny(*, [null])                 = -1
	 *     StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;ab&quot;,&quot;cd&quot;]) = 6
	 *     StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;cd&quot;,&quot;ab&quot;]) = 6
	 *     StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;]) = -1
	 *     StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;]) = -1
	 *     StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;&quot;])   = 10
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStrs
	 *            Ҫ�������ַ�������
	 * 
	 * @return ��һ��ƥ�������ֵ������ַ���Ϊ <code>null</code> ��δ�ҵ����򷵻� <code>-1</code>
	 */
	public static int lastIndexOfAny(String str, String[] searchStrs) {
		if ((str == null) || (searchStrs == null)) {
			return -1;
		}

		int searchStrsLength = searchStrs.length;
		int index = -1;
		int tmp = 0;

		for (int i = 0; i < searchStrsLength; i++) {
			String search = searchStrs[i];

			if (search == null) {
				continue;
			}

			tmp = str.lastIndexOf(search);

			if (tmp > index) {
				index = tmp;
			}
		}

		return index;
	}

	/**
	 * ����ַ������Ƿ����ָ�����ַ�������ַ���Ϊ <code>null</code> �������� <code>false</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.contains(null, *)    = false
	 *     StringUtil.contains(&quot;&quot;, *)      = false
	 *     StringUtil.contains(&quot;abc&quot;, 'a') = true
	 *     StringUtil.contains(&quot;abc&quot;, 'z') = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChar
	 *            Ҫ���ҵ��ַ�
	 * 
	 * @return ����ҵ����򷵻� <code>true</code>
	 */
	public static boolean contains(String str, char searchChar) {
		if ((str == null) || (str.length() == 0)) {
			return false;
		}

		return str.indexOf(searchChar) >= 0;
	}

	/**
	 * ����ַ������Ƿ����ָ�����ַ���������ַ���Ϊ <code>null</code> �������� <code>false</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.contains(null, *)     = false
	 *     StringUtil.contains(*, null)     = false
	 *     StringUtil.contains(&quot;&quot;, &quot;&quot;)      = true
	 *     StringUtil.contains(&quot;abc&quot;, &quot;&quot;)   = true
	 *     StringUtil.contains(&quot;abc&quot;, &quot;a&quot;)  = true
	 *     StringUtil.contains(&quot;abc&quot;, &quot;z&quot;)  = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchStr
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ����ҵ����򷵻� <code>true</code>
	 */
	public static boolean contains(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return false;
		}

		return str.indexOf(searchStr) >= 0;
	}

	/**
	 * ����ַ������Ƿ�ֻ����ָ���ַ������е��ַ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>false</code>�� ����ַ�����Ϊ
	 * <code>null</code> �򷵻� <code>false</code>�� ���ǿ��ַ�����Զ���� <code>true</code>.
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.containsOnly(null, *)       = false
	 *     StringUtil.containsOnly(*, null)       = false
	 *     StringUtil.containsOnly(&quot;&quot;, *)         = true
	 *     StringUtil.containsOnly(&quot;ab&quot;, '')      = false
	 *     StringUtil.containsOnly(&quot;abab&quot;, 'abc') = true
	 *     StringUtil.containsOnly(&quot;ab1&quot;, 'abc')  = false
	 *     StringUtil.containsOnly(&quot;abz&quot;, 'abc')  = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param valid
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ����ҵ����򷵻� <code>true</code>
	 */
	public static boolean containsOnly(String str, char[] valid) {
		if ((valid == null) || (str == null)) {
			return false;
		}

		if (str.length() == 0) {
			return true;
		}

		if (valid.length == 0) {
			return false;
		}

		return indexOfAnyBut(str, valid) == -1;
	}

	/**
	 * ����ַ������Ƿ�ֻ����ָ���ַ������е��ַ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>false</code>�� ����ַ�����Ϊ
	 * <code>null</code> �򷵻� <code>false</code>�� ���ǿ��ַ�����Զ���� <code>true</code>.
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.containsOnly(null, *)       = false
	 *     StringUtil.containsOnly(*, null)       = false
	 *     StringUtil.containsOnly(&quot;&quot;, *)         = true
	 *     StringUtil.containsOnly(&quot;ab&quot;, &quot;&quot;)      = false
	 *     StringUtil.containsOnly(&quot;abab&quot;, &quot;abc&quot;) = true
	 *     StringUtil.containsOnly(&quot;ab1&quot;, &quot;abc&quot;)  = false
	 *     StringUtil.containsOnly(&quot;abz&quot;, &quot;abc&quot;)  = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param valid
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ����ҵ����򷵻� <code>true</code>
	 */
	public static boolean containsOnly(String str, String valid) {
		if ((str == null) || (valid == null)) {
			return false;
		}

		return containsOnly(str, valid.toCharArray());
	}

	/**
	 * ����ַ������Ƿ񲻰���ָ���ַ������е��ַ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>false</code>�� ����ַ�����Ϊ
	 * <code>null</code> �򷵻� <code>true</code>�� ���ǿ��ַ�����Զ���� <code>true</code>.
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.containsNone(null, *)       = true
	 *     StringUtil.containsNone(*, null)       = true
	 *     StringUtil.containsNone(&quot;&quot;, *)         = true
	 *     StringUtil.containsNone(&quot;ab&quot;, '')      = true
	 *     StringUtil.containsNone(&quot;abab&quot;, 'xyz') = true
	 *     StringUtil.containsNone(&quot;ab1&quot;, 'xyz')  = true
	 *     StringUtil.containsNone(&quot;abz&quot;, 'xyz')  = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param invalid
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ����ҵ����򷵻� <code>true</code>
	 */
	public static boolean containsNone(String str, char[] invalid) {
		if ((str == null) || (invalid == null)) {
			return true;
		}

		int strSize = str.length();
		int validSize = invalid.length;

		for (int i = 0; i < strSize; i++) {
			char ch = str.charAt(i);

			for (int j = 0; j < validSize; j++) {
				if (invalid[j] == ch) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * ����ַ������Ƿ񲻰���ָ���ַ������е��ַ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>false</code>�� ����ַ�����Ϊ
	 * <code>null</code> �򷵻� <code>true</code>�� ���ǿ��ַ�����Զ���� <code>true</code>.
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.containsNone(null, *)       = true
	 *     StringUtil.containsNone(*, null)       = true
	 *     StringUtil.containsNone(&quot;&quot;, *)         = true
	 *     StringUtil.containsNone(&quot;ab&quot;, &quot;&quot;)      = true
	 *     StringUtil.containsNone(&quot;abab&quot;, &quot;xyz&quot;) = true
	 *     StringUtil.containsNone(&quot;ab1&quot;, &quot;xyz&quot;)  = true
	 *     StringUtil.containsNone(&quot;abz&quot;, &quot;xyz&quot;)  = false
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param invalidChars
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @return ����ҵ����򷵻� <code>true</code>
	 */
	public static boolean containsNone(String str, String invalidChars) {
		if ((str == null) || (invalidChars == null)) {
			return true;
		}

		return containsNone(str, invalidChars.toCharArray());
	}

	/**
	 * ȡ��ָ���Ӵ����ַ����г��ֵĴ�����
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ��գ��򷵻� <code>0</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.countMatches(null, *)       = 0
	 *     StringUtil.countMatches(&quot;&quot;, *)         = 0
	 *     StringUtil.countMatches(&quot;abba&quot;, null)  = 0
	 *     StringUtil.countMatches(&quot;abba&quot;, &quot;&quot;)    = 0
	 *     StringUtil.countMatches(&quot;abba&quot;, &quot;a&quot;)   = 2
	 *     StringUtil.countMatches(&quot;abba&quot;, &quot;ab&quot;)  = 1
	 *     StringUtil.countMatches(&quot;abba&quot;, &quot;xxx&quot;) = 0
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param subStr
	 *            ���ַ���
	 * 
	 * @return �Ӵ����ַ����г��ֵĴ���������ַ���Ϊ <code>null</code> ��գ��򷵻� <code>0</code>
	 */
	public static int countMatches(String str, String subStr) {
		if ((str == null) || (str.length() == 0) || (subStr == null)
				|| (subStr.length() == 0)) {
			return 0;
		}

		int count = 0;
		int index = 0;

		while ((index = str.indexOf(subStr, index)) != -1) {
			count++;
			index += subStr.length();
		}

		return count;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ȡ�Ӵ������� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ȡָ���ַ������Ӵ���
	 * 
	 * <p>
	 * �������������β����ʼ���㡣����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substring(null, *)   = null
	 *     StringUtil.substring(&quot;&quot;, *)     = &quot;&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 0)  = &quot;abc&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 2)  = &quot;c&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 4)  = &quot;&quot;
	 *     StringUtil.substring(&quot;abc&quot;, -2) = &quot;bc&quot;
	 *     StringUtil.substring(&quot;abc&quot;, -4) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param start
	 *            ��ʼ���������Ϊ��������ʾ��β������
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String substring(String str, int start) {
		if (str == null) {
			return null;
		}

		if (start < 0) {
			start = str.length() + start;
		}

		if (start < 0) {
			start = 0;
		}

		if (start > str.length()) {
			return EMPTY_STRING;
		}

		return str.substring(start);
	}

	/**
	 * ȡָ���ַ������Ӵ���
	 * 
	 * <p>
	 * �������������β����ʼ���㡣����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substring(null, *, *)    = null
	 *     StringUtil.substring(&quot;&quot;, * ,  *)    = &quot;&quot;;
	 *     StringUtil.substring(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 2, 0)   = &quot;&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 4, 6)   = &quot;&quot;
	 *     StringUtil.substring(&quot;abc&quot;, 2, 2)   = &quot;&quot;
	 *     StringUtil.substring(&quot;abc&quot;, -2, -1) = &quot;b&quot;
	 *     StringUtil.substring(&quot;abc&quot;, -4, 2)  = &quot;ab&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param start
	 *            ��ʼ���������Ϊ��������ʾ��β������
	 * @param end
	 *            ���������������������Ϊ��������ʾ��β������
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String substring(String str, int start, int end) {
		if (str == null) {
			return null;
		}

		if (end < 0) {
			end = str.length() + end;
		}

		if (start < 0) {
			start = str.length() + start;
		}

		if (end > str.length()) {
			end = str.length();
		}

		if (start > end) {
			return EMPTY_STRING;
		}

		if (start < 0) {
			start = 0;
		}

		if (end < 0) {
			end = 0;
		}

		return str.substring(start, end);
	}

	/**
	 * ȡ�ó���Ϊָ���ַ���������ߵ��Ӵ���
	 * 
	 * <pre>
	 * 
	 *     StringUtil.left(null, *)    = null
	 *     StringUtil.left(*, -ve)     = &quot;&quot;
	 *     StringUtil.left(&quot;&quot;, *)      = &quot;&quot;
	 *     StringUtil.left(&quot;abc&quot;, 0)   = &quot;&quot;
	 *     StringUtil.left(&quot;abc&quot;, 2)   = &quot;ab&quot;
	 *     StringUtil.left(&quot;abc&quot;, 4)   = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            �ַ���
	 * @param len
	 *            �����Ӵ��ĳ���
	 * 
	 * @return �Ӵ������ԭʼ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String left(String str, int len) {
		if (str == null) {
			return null;
		}

		if (len < 0) {
			return EMPTY_STRING;
		}

		if (str.length() <= len) {
			return str;
		} else {
			return str.substring(0, len);
		}
	}

	/**
	 * ȡ�ó���Ϊָ���ַ��������ұߵ��Ӵ���
	 * 
	 * <pre>
	 * 
	 *     StringUtil.right(null, *)    = null
	 *     StringUtil.right(*, -ve)     = &quot;&quot;
	 *     StringUtil.right(&quot;&quot;, *)      = &quot;&quot;
	 *     StringUtil.right(&quot;abc&quot;, 0)   = &quot;&quot;
	 *     StringUtil.right(&quot;abc&quot;, 2)   = &quot;bc&quot;
	 *     StringUtil.right(&quot;abc&quot;, 4)   = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            �ַ���
	 * @param len
	 *            �����Ӵ��ĳ���
	 * 
	 * @return �Ӵ������ԭʼ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String right(String str, int len) {
		if (str == null) {
			return null;
		}

		if (len < 0) {
			return EMPTY_STRING;
		}

		if (str.length() <= len) {
			return str;
		} else {
			return str.substring(str.length() - len);
		}
	}

	/**
	 * ȡ�ô�ָ��������ʼ����ġ�����Ϊָ���ַ������Ӵ���
	 * 
	 * <pre>
	 * 
	 *     StringUtil.mid(null, *, *)    = null
	 *     StringUtil.mid(*, *, -ve)     = &quot;&quot;
	 *     StringUtil.mid(&quot;&quot;, 0, *)      = &quot;&quot;
	 *     StringUtil.mid(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
	 *     StringUtil.mid(&quot;abc&quot;, 0, 4)   = &quot;abc&quot;
	 *     StringUtil.mid(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
	 *     StringUtil.mid(&quot;abc&quot;, 4, 2)   = &quot;&quot;
	 *     StringUtil.mid(&quot;abc&quot;, -2, 2)  = &quot;ab&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            �ַ���
	 * @param pos
	 *            ��ʼ���������Ϊ���������� <code>0</code>
	 * @param len
	 *            �Ӵ��ĳ��ȣ����Ϊ��������������Ϊ <code>0</code>
	 * 
	 * @return �Ӵ������ԭʼ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String mid(String str, int pos, int len) {
		if (str == null) {
			return null;
		}

		if ((len < 0) || (pos > str.length())) {
			return EMPTY_STRING;
		}

		if (pos < 0) {
			pos = 0;
		}

		if (str.length() <= (pos + len)) {
			return str.substring(pos);
		} else {
			return str.substring(pos, pos + len);
		}
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ������ȡ�Ӵ������� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ȡ�õ�һ�����ֵķָ��Ӵ�֮ǰ���Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ��δ�ҵ����Ӵ����򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringBefore(null, *)      = null
	 *     StringUtil.substringBefore(&quot;&quot;, *)        = &quot;&quot;
	 *     StringUtil.substringBefore(&quot;abc&quot;, &quot;a&quot;)   = &quot;&quot;
	 *     StringUtil.substringBefore(&quot;abcba&quot;, &quot;b&quot;) = &quot;a&quot;
	 *     StringUtil.substringBefore(&quot;abc&quot;, &quot;c&quot;)   = &quot;ab&quot;
	 *     StringUtil.substringBefore(&quot;abc&quot;, &quot;d&quot;)   = &quot;abc&quot;
	 *     StringUtil.substringBefore(&quot;abc&quot;, &quot;&quot;)    = &quot;&quot;
	 *     StringUtil.substringBefore(&quot;abc&quot;, null)  = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param separator
	 *            Ҫ�����ķָ��Ӵ�
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String substringBefore(String str, String separator) {
		if ((str == null) || (separator == null) || (str.length() == 0)) {
			return str;
		}

		if (separator.length() == 0) {
			return EMPTY_STRING;
		}

		int pos = str.indexOf(separator);

		if (pos == -1) {
			return str;
		}

		return str.substring(0, pos);
	}

	/**
	 * ȡ�õ�һ�����ֵķָ��Ӵ�֮����Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ��δ�ҵ����Ӵ����򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringAfter(null, *)      = null
	 *     StringUtil.substringAfter(&quot;&quot;, *)        = &quot;&quot;
	 *     StringUtil.substringAfter(*, null)      = &quot;&quot;
	 *     StringUtil.substringAfter(&quot;abc&quot;, &quot;a&quot;)   = &quot;bc&quot;
	 *     StringUtil.substringAfter(&quot;abcba&quot;, &quot;b&quot;) = &quot;cba&quot;
	 *     StringUtil.substringAfter(&quot;abc&quot;, &quot;c&quot;)   = &quot;&quot;
	 *     StringUtil.substringAfter(&quot;abc&quot;, &quot;d&quot;)   = &quot;&quot;
	 *     StringUtil.substringAfter(&quot;abc&quot;, &quot;&quot;)    = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param separator
	 *            Ҫ�����ķָ��Ӵ�
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String substringAfter(String str, String separator) {
		if ((str == null) || (str.length() == 0)) {
			return str;
		}

		if (separator == null) {
			return EMPTY_STRING;
		}

		int pos = str.indexOf(separator);

		if (pos == -1) {
			return EMPTY_STRING;
		}

		return str.substring(pos + separator.length());
	}

	/**
	 * ȡ�����һ���ķָ��Ӵ�֮ǰ���Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ��δ�ҵ����Ӵ����򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringBeforeLast(null, *)      = null
	 *     StringUtil.substringBeforeLast(&quot;&quot;, *)        = &quot;&quot;
	 *     StringUtil.substringBeforeLast(&quot;abcba&quot;, &quot;b&quot;) = &quot;abc&quot;
	 *     StringUtil.substringBeforeLast(&quot;abc&quot;, &quot;c&quot;)   = &quot;ab&quot;
	 *     StringUtil.substringBeforeLast(&quot;a&quot;, &quot;a&quot;)     = &quot;&quot;
	 *     StringUtil.substringBeforeLast(&quot;a&quot;, &quot;z&quot;)     = &quot;a&quot;
	 *     StringUtil.substringBeforeLast(&quot;a&quot;, null)    = &quot;a&quot;
	 *     StringUtil.substringBeforeLast(&quot;a&quot;, &quot;&quot;)      = &quot;a&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param separator
	 *            Ҫ�����ķָ��Ӵ�
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String substringBeforeLast(String str, String separator) {
		if ((str == null) || (separator == null) || (str.length() == 0)
				|| (separator.length() == 0)) {
			return str;
		}

		int pos = str.lastIndexOf(separator);

		if (pos == -1) {
			return str;
		}

		return str.substring(0, pos);
	}

	/**
	 * ȡ�����һ���ķָ��Ӵ�֮����Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ��δ�ҵ����Ӵ����򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringAfterLast(null, *)      = null
	 *     StringUtil.substringAfterLast(&quot;&quot;, *)        = &quot;&quot;
	 *     StringUtil.substringAfterLast(*, &quot;&quot;)        = &quot;&quot;
	 *     StringUtil.substringAfterLast(*, null)      = &quot;&quot;
	 *     StringUtil.substringAfterLast(&quot;abc&quot;, &quot;a&quot;)   = &quot;bc&quot;
	 *     StringUtil.substringAfterLast(&quot;abcba&quot;, &quot;b&quot;) = &quot;a&quot;
	 *     StringUtil.substringAfterLast(&quot;abc&quot;, &quot;c&quot;)   = &quot;&quot;
	 *     StringUtil.substringAfterLast(&quot;a&quot;, &quot;a&quot;)     = &quot;&quot;
	 *     StringUtil.substringAfterLast(&quot;a&quot;, &quot;z&quot;)     = &quot;&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param separator
	 *            Ҫ�����ķָ��Ӵ�
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String substringAfterLast(String str, String separator) {
		if ((str == null) || (str.length() == 0)) {
			return str;
		}

		if ((separator == null) || (separator.length() == 0)) {
			return EMPTY_STRING;
		}

		int pos = str.lastIndexOf(separator);

		if ((pos == -1) || (pos == (str.length() - separator.length()))) {
			return EMPTY_STRING;
		}

		return str.substring(pos + separator.length());
	}

	/**
	 * ȡ��ָ���ָ�����ǰ���γ���֮����Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringBetween(null, *)            = null
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;&quot;)             = &quot;&quot;
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;tag&quot;)          = null
	 *     StringUtil.substringBetween(&quot;tagabctag&quot;, null)  = null
	 *     StringUtil.substringBetween(&quot;tagabctag&quot;, &quot;&quot;)    = &quot;&quot;
	 *     StringUtil.substringBetween(&quot;tagabctag&quot;, &quot;tag&quot;) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param tag
	 *            Ҫ�����ķָ��Ӵ�
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ��δ�ҵ��ָ��Ӵ����򷵻� <code>null</code>
	 */
	public static String substringBetween(String str, String tag) {
		return substringBetween(str, tag, tag, 0);
	}

	/**
	 * ȡ�������ָ���֮����Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringBetween(null, *, *)          = null
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;&quot;, &quot;&quot;)          = &quot;&quot;
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;&quot;, &quot;tag&quot;)       = null
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;tag&quot;, &quot;tag&quot;)    = null
	 *     StringUtil.substringBetween(&quot;yabcz&quot;, null, null) = null
	 *     StringUtil.substringBetween(&quot;yabcz&quot;, &quot;&quot;, &quot;&quot;)     = &quot;&quot;
	 *     StringUtil.substringBetween(&quot;yabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
	 *     StringUtil.substringBetween(&quot;yabczyabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param open
	 *            Ҫ�����ķָ��Ӵ�1
	 * @param close
	 *            Ҫ�����ķָ��Ӵ�2
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ��δ�ҵ��ָ��Ӵ����򷵻� <code>null</code>
	 */
	public static String substringBetween(String str, String open, String close) {
		return substringBetween(str, open, close, 0);
	}

	/**
	 * ȡ�������ָ���֮����Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ����ָ��Ӵ�Ϊ
	 * <code>null</code> ���򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.substringBetween(null, *, *)          = null
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;&quot;, &quot;&quot;)          = &quot;&quot;
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;&quot;, &quot;tag&quot;)       = null
	 *     StringUtil.substringBetween(&quot;&quot;, &quot;tag&quot;, &quot;tag&quot;)    = null
	 *     StringUtil.substringBetween(&quot;yabcz&quot;, null, null) = null
	 *     StringUtil.substringBetween(&quot;yabcz&quot;, &quot;&quot;, &quot;&quot;)     = &quot;&quot;
	 *     StringUtil.substringBetween(&quot;yabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
	 *     StringUtil.substringBetween(&quot;yabczyabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            �ַ���
	 * @param open
	 *            Ҫ�����ķָ��Ӵ�1
	 * @param close
	 *            Ҫ�����ķָ��Ӵ�2
	 * @param fromIndex
	 *            ��ָ��index������
	 * 
	 * @return �Ӵ������ԭʼ��Ϊ <code>null</code> ��δ�ҵ��ָ��Ӵ����򷵻� <code>null</code>
	 */
	public static String substringBetween(String str, String open,
			String close, int fromIndex) {
		if ((str == null) || (open == null) || (close == null)) {
			return null;
		}

		int start = str.indexOf(open, fromIndex);

		if (start != -1) {
			int end = str.indexOf(close, start + open.length());

			if (end != -1) {
				return str.substring(start + open.length(), end);
			}
		}

		return null;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ɾ���ַ��� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ɾ�������� <code>Character.isWhitespace(char)</code> ��������Ŀհס�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.deleteWhitespace(null)         = null
	 *     StringUtil.deleteWhitespace(&quot;&quot;)           = &quot;&quot;
	 *     StringUtil.deleteWhitespace(&quot;abc&quot;)        = &quot;abc&quot;
	 *     StringUtil.deleteWhitespace(&quot;   ab  c  &quot;) = &quot;abc&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ȥ�հ׺���ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String deleteWhitespace(String str) {
		if (str == null) {
			return null;
		}

		int sz = str.length();
		StringBuffer buffer = new StringBuffer(sz);

		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				buffer.append(str.charAt(i));
			}
		}

		return buffer.toString();
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �滻�Ӵ��� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * �滻ָ�����Ӵ���ֻ�滻��һ�����ֵ��Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> �򷵻� <code>null</code> �����ָ���Ӵ�Ϊ <code>null</code>
	 * ���򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.replaceOnce(null, *, *)        = null
	 *     StringUtil.replaceOnce(&quot;&quot;, *, *)          = &quot;&quot;
	 *     StringUtil.replaceOnce(&quot;aba&quot;, null, null) = &quot;aba&quot;
	 *     StringUtil.replaceOnce(&quot;aba&quot;, null, null) = &quot;aba&quot;
	 *     StringUtil.replaceOnce(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
	 *     StringUtil.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;ba&quot;
	 *     StringUtil.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zba&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param text
	 *            Ҫɨ����ַ���
	 * @param repl
	 *            Ҫ�������Ӵ�
	 * @param with
	 *            �滻�ַ���
	 * 
	 * @return ���滻����ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String replaceOnce(String text, String repl, String with) {
		return replace(text, repl, with, 1);
	}

	/**
	 * �滻ָ�����Ӵ����滻���г��ֵ��Ӵ���
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> �򷵻� <code>null</code> �����ָ���Ӵ�Ϊ <code>null</code>
	 * ���򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.replace(null, *, *)        = null
	 *     StringUtil.replace(&quot;&quot;, *, *)          = &quot;&quot;
	 *     StringUtil.replace(&quot;aba&quot;, null, null) = &quot;aba&quot;
	 *     StringUtil.replace(&quot;aba&quot;, null, null) = &quot;aba&quot;
	 *     StringUtil.replace(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
	 *     StringUtil.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;b&quot;
	 *     StringUtil.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zbz&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param text
	 *            Ҫɨ����ַ���
	 * @param repl
	 *            Ҫ�������Ӵ�
	 * @param with
	 *            �滻�ַ���
	 * 
	 * @return ���滻����ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String replace(String text, String repl, String with) {
		return replace(text, repl, with, -1);
	}

	/**
	 * �滻ָ�����Ӵ����滻ָ���Ĵ�����
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> �򷵻� <code>null</code> �����ָ���Ӵ�Ϊ <code>null</code>
	 * ���򷵻�ԭ�ַ�����
	 * 
	 * <pre>
	 * 
	 *     StringUtil.replace(null, *, *, *)         = null
	 *     StringUtil.replace(&quot;&quot;, *, *, *)           = &quot;&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, null, null, 1) = &quot;abaa&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, null, null, 1) = &quot;abaa&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, null, 1)  = &quot;abaa&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;&quot;, 1)    = &quot;baa&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 0)   = &quot;abaa&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 1)   = &quot;zbaa&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 2)   = &quot;zbza&quot;
	 *     StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, -1)  = &quot;zbzz&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param text
	 *            Ҫɨ����ַ���
	 * @param repl
	 *            Ҫ�������Ӵ�
	 * @param with
	 *            �滻�ַ���
	 * @param max
	 *            maximum number of values to replace, or <code>-1</code> if no
	 *            maximum
	 * 
	 * @return ���滻����ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String replace(String text, String repl, String with, int max) {
		if ((text == null) || (repl == null) || (with == null)
				|| (repl.length() == 0) || (max == 0)) {
			return text;
		}

		StringBuffer buf = new StringBuffer(text.length());
		int start = 0;
		int end = 0;

		while ((end = text.indexOf(repl, start)) != -1) {
			buf.append(text.substring(start, end)).append(with);
			start = end + repl.length();

			if (--max == 0) {
				break;
			}
		}

		buf.append(text.substring(start));
		return buf.toString();
	}

	/**
	 * ���ַ���������ָ�����ַ����滻����һ����
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> �򷵻� <code>null</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.replaceChars(null, *, *)        = null
	 *     StringUtil.replaceChars(&quot;&quot;, *, *)          = &quot;&quot;
	 *     StringUtil.replaceChars(&quot;abcba&quot;, 'b', 'y') = &quot;aycya&quot;
	 *     StringUtil.replaceChars(&quot;abcba&quot;, 'z', 'y') = &quot;abcba&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChar
	 *            Ҫ�������ַ�
	 * @param replaceChar
	 *            �滻�ַ�
	 * 
	 * @return ���滻����ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String replaceChars(String str, char searchChar,
			char replaceChar) {
		if (str == null) {
			return null;
		}

		return str.replace(searchChar, replaceChar);
	}

	/**
	 * ���ַ���������ָ�����ַ����滻����һ����
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> �򷵻� <code>null</code> ����������ַ���Ϊ
	 * <code>null</code> ��գ��򷵻�ԭ�ַ�����
	 * </p>
	 * 
	 * <p>
	 * ���磺
	 * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>
	 * ��
	 * </p>
	 * 
	 * <p>
	 * ͨ�������ַ������滻�ַ����ǵȳ��ģ���������ַ������滻�ַ��������������ַ�����ɾ���� ��������ַ������滻�ַ����̣���ȱ�ٵ��ַ��������ԡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.replaceChars(null, *, *)           = null
	 *     StringUtil.replaceChars(&quot;&quot;, *, *)             = &quot;&quot;
	 *     StringUtil.replaceChars(&quot;abc&quot;, null, *)       = &quot;abc&quot;
	 *     StringUtil.replaceChars(&quot;abc&quot;, &quot;&quot;, *)         = &quot;abc&quot;
	 *     StringUtil.replaceChars(&quot;abc&quot;, &quot;b&quot;, null)     = &quot;ac&quot;
	 *     StringUtil.replaceChars(&quot;abc&quot;, &quot;b&quot;, &quot;&quot;)       = &quot;ac&quot;
	 *     StringUtil.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yz&quot;)  = &quot;ayzya&quot;
	 *     StringUtil.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;y&quot;)   = &quot;ayya&quot;
	 *     StringUtil.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yzx&quot;) = &quot;ayzya&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param searchChars
	 *            Ҫ�������ַ���
	 * @param replaceChars
	 *            �滻�ַ���
	 * 
	 * @return ���滻����ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String replaceChars(String str, String searchChars,
			String replaceChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length() == 0)) {
			return str;
		}

		char[] chars = str.toCharArray();
		int len = chars.length;
		boolean modified = false;

		for (int i = 0, isize = searchChars.length(); i < isize; i++) {
			char searchChar = searchChars.charAt(i);

			if ((replaceChars == null) || (i >= replaceChars.length())) {
				// ɾ��
				int pos = 0;

				for (int j = 0; j < len; j++) {
					if (chars[j] != searchChar) {
						chars[pos++] = chars[j];
					} else {
						modified = true;
					}
				}

				len = pos;
			} else {
				// �滻
				for (int j = 0; j < len; j++) {
					if (chars[j] == searchChar) {
						chars[j] = replaceChars.charAt(i);
						modified = true;
					}
				}
			}
		}

		if (!modified) {
			return str;
		}

		return new String(chars, 0, len);
	}

	/**
	 * ��ָ�����Ӵ�����һָ���Ӵ����ǡ�
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>�� ��������ֵ�������� <code>0</code>
	 * ��Խ�������ֵ�������ó��ַ����ĳ�����ͬ��ֵ��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.overlay(null, *, *, *)            = null
	 *     StringUtil.overlay(&quot;&quot;, &quot;abc&quot;, 0, 0)          = &quot;abc&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, null, 2, 4)     = &quot;abef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;&quot;, 2, 4)       = &quot;abef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;&quot;, 4, 2)       = &quot;abef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 4)   = &quot;abzzzzef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 4, 2)   = &quot;abzzzzef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, -1, 4)  = &quot;zzzzef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 8)   = &quot;abzzzz&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, -2, -3) = &quot;zzzzabcdef&quot;
	 *     StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 8, 10)  = &quot;abcdefzzzz&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫɨ����ַ���
	 * @param overlay
	 *            �������ǵ��ַ���
	 * @param start
	 *            ��ʼ����
	 * @param end
	 *            ��������
	 * 
	 * @return �����Ǻ���ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String overlay(String str, String overlay, int start, int end) {
		if (str == null) {
			return null;
		}

		if (overlay == null) {
			overlay = EMPTY_STRING;
		}

		int len = str.length();

		if (start < 0) {
			start = 0;
		}

		if (start > len) {
			start = len;
		}

		if (end < 0) {
			end = 0;
		}

		if (end > len) {
			end = len;
		}

		if (start > end) {
			int temp = start;

			start = end;
			end = temp;
		}

		return new StringBuffer((len + start) - end + overlay.length() + 1)
				.append(str.substring(0, start)).append(overlay)
				.append(str.substring(end)).toString();
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Perl����chomp��chop������ */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ɾ���ַ���ĩβ�Ļ��з�������ַ������Ի��н�β����ʲôҲ������
	 * 
	 * <p>
	 * ���з����������Σ�&quot; <code>\n</code> &quot;��&quot; <code>\r</code>
	 * &quot;��&quot; <code>\r\n</code> &quot;��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.chomp(null)          = null
	 *     StringUtil.chomp(&quot;&quot;)            = &quot;&quot;
	 *     StringUtil.chomp(&quot;abc \r&quot;)      = &quot;abc &quot;
	 *     StringUtil.chomp(&quot;abc\n&quot;)       = &quot;abc&quot;
	 *     StringUtil.chomp(&quot;abc\r\n&quot;)     = &quot;abc&quot;
	 *     StringUtil.chomp(&quot;abc\r\n\r\n&quot;) = &quot;abc\r\n&quot;
	 *     StringUtil.chomp(&quot;abc\n\r&quot;)     = &quot;abc\n&quot;
	 *     StringUtil.chomp(&quot;abc\n\rabc&quot;)  = &quot;abc\n\rabc&quot;
	 *     StringUtil.chomp(&quot;\r&quot;)          = &quot;&quot;
	 *     StringUtil.chomp(&quot;\n&quot;)          = &quot;&quot;
	 *     StringUtil.chomp(&quot;\r\n&quot;)        = &quot;&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ���Ի��н�β���ַ��������ԭʼ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String chomp(String str) {
		if ((str == null) || (str.length() == 0)) {
			return str;
		}

		if (str.length() == 1) {
			char ch = str.charAt(0);

			if ((ch == '\r') || (ch == '\n')) {
				return EMPTY_STRING;
			} else {
				return str;
			}
		}

		int lastIdx = str.length() - 1;
		char last = str.charAt(lastIdx);

		if (last == '\n') {
			if (str.charAt(lastIdx - 1) == '\r') {
				lastIdx--;
			}
		} else if (last == '\r') {
		} else {
			lastIdx++;
		}

		return str.substring(0, lastIdx);
	}

	/**
	 * ɾ���ַ���ĩβ��ָ���ַ���������ַ������Ը��ַ�����β����ʲôҲ������
	 * 
	 * <pre>
	 * 
	 *     StringUtil.chomp(null, *)         = null
	 *     StringUtil.chomp(&quot;&quot;, *)           = &quot;&quot;
	 *     StringUtil.chomp(&quot;foobar&quot;, &quot;bar&quot;) = &quot;foo&quot;
	 *     StringUtil.chomp(&quot;foobar&quot;, &quot;baz&quot;) = &quot;foobar&quot;
	 *     StringUtil.chomp(&quot;foo&quot;, &quot;foo&quot;)    = &quot;&quot;
	 *     StringUtil.chomp(&quot;foo &quot;, &quot;foo&quot;)   = &quot;foo &quot;
	 *     StringUtil.chomp(&quot; foo&quot;, &quot;foo&quot;)   = &quot; &quot;
	 *     StringUtil.chomp(&quot;foo&quot;, &quot;foooo&quot;)  = &quot;foo&quot;
	 *     StringUtil.chomp(&quot;foo&quot;, &quot;&quot;)       = &quot;foo&quot;
	 *     StringUtil.chomp(&quot;foo&quot;, null)     = &quot;foo&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param separator
	 *            Ҫɾ�����ַ���
	 * 
	 * @return ����ָ���ַ�����β���ַ��������ԭʼ�ִ�Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String chomp(String str, String separator) {
		if ((str == null) || (str.length() == 0) || (separator == null)) {
			return str;
		}

		if (str.endsWith(separator)) {
			return str.substring(0, str.length() - separator.length());
		}

		return str;
	}

	/**
	 * ɾ�����һ���ַ���
	 * 
	 * <p>
	 * ����ַ����� <code>\r\n</code> ��β����ͬʱɾ�����ǡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.chop(null)          = null
	 *     StringUtil.chop(&quot;&quot;)            = &quot;&quot;
	 *     StringUtil.chop(&quot;abc \r&quot;)      = &quot;abc &quot;
	 *     StringUtil.chop(&quot;abc\n&quot;)       = &quot;abc&quot;
	 *     StringUtil.chop(&quot;abc\r\n&quot;)     = &quot;abc&quot;
	 *     StringUtil.chop(&quot;abc&quot;)         = &quot;ab&quot;
	 *     StringUtil.chop(&quot;abc\nabc&quot;)    = &quot;abc\nab&quot;
	 *     StringUtil.chop(&quot;a&quot;)           = &quot;&quot;
	 *     StringUtil.chop(&quot;\r&quot;)          = &quot;&quot;
	 *     StringUtil.chop(&quot;\n&quot;)          = &quot;&quot;
	 *     StringUtil.chop(&quot;\r\n&quot;)        = &quot;&quot;
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * 
	 * @return ɾ�����һ���ַ����ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String chop(String str) {
		if (str == null) {
			return null;
		}

		int strLen = str.length();

		if (strLen < 2) {
			return EMPTY_STRING;
		}

		int lastIdx = strLen - 1;
		String ret = str.substring(0, lastIdx);
		char last = str.charAt(lastIdx);

		if (last == '\n') {
			if (ret.charAt(lastIdx - 1) == '\r') {
				return ret.substring(0, lastIdx - 1);
			}
		}

		return ret;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �ظ�/�����ַ����� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ��ָ���ַ����ظ�n�顣
	 * 
	 * <pre>
	 * 
	 *     StringUtil.repeat(null, 2)   = null
	 *     StringUtil.repeat(&quot;&quot;, 0)     = &quot;&quot;
	 *     StringUtil.repeat(&quot;&quot;, 2)     = &quot;&quot;
	 *     StringUtil.repeat(&quot;a&quot;, 3)    = &quot;aaa&quot;
	 *     StringUtil.repeat(&quot;ab&quot;, 2)   = &quot;abab&quot;
	 *     StringUtil.repeat(&quot;abcd&quot;, 2) = &quot;abcdabcd&quot;
	 *     StringUtil.repeat(&quot;a&quot;, -2)   = &quot;&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�ظ����ַ���
	 * @param repeat
	 *            �ظ����������С�� <code>0</code> ������ <code>0</code>
	 * 
	 * @return �ظ�n�ε��ַ��������ԭʼ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String repeat(String str, int repeat) {
		if (str == null) {
			return null;
		}

		if (repeat <= 0) {
			return EMPTY_STRING;
		}

		int inputLength = str.length();

		if ((repeat == 1) || (inputLength == 0)) {
			return str;
		}

		int outputLength = inputLength * repeat;

		switch (inputLength) {
		case 1:

			char ch = str.charAt(0);
			char[] output1 = new char[outputLength];

			for (int i = repeat - 1; i >= 0; i--) {
				output1[i] = ch;
			}

			return new String(output1);

		case 2:

			char ch0 = str.charAt(0);
			char ch1 = str.charAt(1);
			char[] output2 = new char[outputLength];

			for (int i = (repeat * 2) - 2; i >= 0; i--, i--) {
				output2[i] = ch0;
				output2[i + 1] = ch1;
			}

			return new String(output2);

		default:

			StringBuffer buf = new StringBuffer(outputLength);

			for (int i = 0; i < repeat; i++) {
				buf.append(str);
			}

			return buf.toString();
		}
	}

	/**
	 * ��չ��������ַ������ÿո� <code>' '</code> ����ұߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.alignLeft(null, *)   = null
	 *     StringUtil.alignLeft(&quot;&quot;, 3)     = &quot;   &quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 3)  = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 5)  = &quot;bat  &quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 1)  = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, -1) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String alignLeft(String str, int size) {
		return alignLeft(str, size, ' ');
	}

	/**
	 * ��չ��������ַ�������ָ���ַ�����ұߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.alignLeft(null, *, *)     = null
	 *     StringUtil.alignLeft(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 5, 'z')  = &quot;batzz&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * @param padChar
	 *            ����ַ�
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String alignLeft(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}

		int pads = size - str.length();

		if (pads <= 0) {
			return str;
		}

		return alignLeft(str, size, String.valueOf(padChar));
	}

	/**
	 * ��չ��������ַ�������ָ���ַ�������ұߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.alignLeft(null, *, *)      = null
	 *     StringUtil.alignLeft(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;batyz&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;batyzyzy&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 5, null)  = &quot;bat  &quot;
	 *     StringUtil.alignLeft(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;bat  &quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * @param padStr
	 *            ����ַ���
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String alignLeft(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}

		if ((padStr == null) || (padStr.length() == 0)) {
			padStr = " ";
		}

		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;

		if (pads <= 0) {
			return str;
		}

		if (pads == padLen) {
			return str.concat(padStr);
		} else if (pads < padLen) {
			return str.concat(padStr.substring(0, pads));
		} else {
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();

			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}

			return str.concat(new String(padding));
		}
	}

	/**
	 * ��չ���Ҷ����ַ������ÿո� <code>' '</code> �����ߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.alignRight(null, *)   = null
	 *     StringUtil.alignRight(&quot;&quot;, 3)     = &quot;   &quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 3)  = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 5)  = &quot;  bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 1)  = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, -1) = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String alignRight(String str, int size) {
		return alignRight(str, size, ' ');
	}

	/**
	 * ��չ���Ҷ����ַ�������ָ���ַ������ߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.alignRight(null, *, *)     = null
	 *     StringUtil.alignRight(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 5, 'z')  = &quot;zzbat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * @param padChar
	 *            ����ַ�
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String alignRight(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}

		int pads = size - str.length();

		if (pads <= 0) {
			return str;
		}

		return alignRight(str, size, String.valueOf(padChar));
	}

	/**
	 * ��չ���Ҷ����ַ�������ָ���ַ��������ߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.alignRight(null, *, *)      = null
	 *     StringUtil.alignRight(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;yzbat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;yzyzybat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 5, null)  = &quot;  bat&quot;
	 *     StringUtil.alignRight(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;  bat&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * @param padStr
	 *            ����ַ���
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String alignRight(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}

		if ((padStr == null) || (padStr.length() == 0)) {
			padStr = " ";
		}

		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;

		if (pads <= 0) {
			return str;
		}

		if (pads == padLen) {
			return padStr.concat(str);
		} else if (pads < padLen) {
			return padStr.substring(0, pads).concat(str);
		} else {
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();

			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}

			return new String(padding).concat(str);
		}
	}

	/**
	 * ��չ�������ַ������ÿո� <code>' '</code> ������ߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.center(null, *)   = null
	 *     StringUtil.center(&quot;&quot;, 4)     = &quot;    &quot;
	 *     StringUtil.center(&quot;ab&quot;, -1)  = &quot;ab&quot;
	 *     StringUtil.center(&quot;ab&quot;, 4)   = &quot; ab &quot;
	 *     StringUtil.center(&quot;abcd&quot;, 2) = &quot;abcd&quot;
	 *     StringUtil.center(&quot;a&quot;, 4)    = &quot; a  &quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String center(String str, int size) {
		return center(str, size, ' ');
	}

	/**
	 * ��չ�������ַ�������ָ���ַ�������ߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.center(null, *, *)     = null
	 *     StringUtil.center(&quot;&quot;, 4, ' ')     = &quot;    &quot;
	 *     StringUtil.center(&quot;ab&quot;, -1, ' ')  = &quot;ab&quot;
	 *     StringUtil.center(&quot;ab&quot;, 4, ' ')   = &quot; ab &quot;
	 *     StringUtil.center(&quot;abcd&quot;, 2, ' ') = &quot;abcd&quot;
	 *     StringUtil.center(&quot;a&quot;, 4, ' ')    = &quot; a  &quot;
	 *     StringUtil.center(&quot;a&quot;, 4, 'y')    = &quot;yayy&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * @param padChar
	 *            ����ַ�
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String center(String str, int size, char padChar) {
		if ((str == null) || (size <= 0)) {
			return str;
		}

		int strLen = str.length();
		int pads = size - strLen;

		if (pads <= 0) {
			return str;
		}

		str = alignRight(str, strLen + (pads / 2), padChar);
		str = alignLeft(str, size, padChar);
		return str;
	}

	/**
	 * ��չ�������ַ�������ָ���ַ���������ߡ�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.center(null, *, *)     = null
	 *     StringUtil.center(&quot;&quot;, 4, &quot; &quot;)     = &quot;    &quot;
	 *     StringUtil.center(&quot;ab&quot;, -1, &quot; &quot;)  = &quot;ab&quot;
	 *     StringUtil.center(&quot;ab&quot;, 4, &quot; &quot;)   = &quot; ab &quot;
	 *     StringUtil.center(&quot;abcd&quot;, 2, &quot; &quot;) = &quot;abcd&quot;
	 *     StringUtil.center(&quot;a&quot;, 4, &quot; &quot;)    = &quot; a  &quot;
	 *     StringUtil.center(&quot;a&quot;, 4, &quot;yz&quot;)   = &quot;yayz&quot;
	 *     StringUtil.center(&quot;abc&quot;, 7, null) = &quot;  abc  &quot;
	 *     StringUtil.center(&quot;abc&quot;, 7, &quot;&quot;)   = &quot;  abc  &quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @param size
	 *            ��չ�ַ�����ָ�����
	 * @param padStr
	 *            ����ַ���
	 * 
	 * @return ��չ����ַ���������ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String center(String str, int size, String padStr) {
		if ((str == null) || (size <= 0)) {
			return str;
		}

		if ((padStr == null) || (padStr.length() == 0)) {
			padStr = " ";
		}

		int strLen = str.length();
		int pads = size - strLen;

		if (pads <= 0) {
			return str;
		}

		str = alignRight(str, strLen + (pads / 2), padStr);
		str = alignLeft(str, size, padStr);
		return str;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ��ת�ַ����� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ��ת�ַ����е��ַ�˳��
	 * 
	 * <p>
	 * ����ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>��
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.reverse(null)  = null
	 *     StringUtil.reverse(&quot;&quot;)    = &quot;&quot;
	 *     StringUtil.reverse(&quot;bat&quot;) = &quot;tab&quot;
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ��ת���ַ���
	 * 
	 * @return ��ת����ַ��������ԭ�ַ���Ϊ <code>null</code> ���򷵻� <code>null</code>
	 */
	public static String reverse(String str) {
		if ((str == null) || (str.length() == 0)) {
			return str;
		}

		return new StringBuffer(str).reverse().toString();
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ȡ���ַ��������ԡ� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * ���ַ���ת����ָ�����ȵ����ԣ����磺 ��"Now is the time for all good men"ת����"Now is the time
	 * for..."��
	 * 
	 * <ul>
	 * <li>��� <code>str</code> �� <code>maxWidth</code> �̣�ֱ�ӷ��أ�</li>
	 * <li>������ת�������ԣ� <code>substring(str, 0, max-3) + "..."</code>��</li>
	 * <li>��� <code>maxWidth</code> С�� <code>4</code> �׳�
	 * <code>IllegalArgumentException</code>��</li>
	 * <li>���ص��ַ��������ܳ���ָ���� <code>maxWidth</code>��</li>
	 * </ul>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.abbreviate(null, *)      = null
	 *     StringUtil.abbreviate(&quot;&quot;, 4)        = &quot;&quot;
	 *     StringUtil.abbreviate(&quot;abcdefg&quot;, 6) = &quot;abc...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefg&quot;, 7) = &quot;abcdefg&quot;
	 *     StringUtil.abbreviate(&quot;abcdefg&quot;, 8) = &quot;abcdefg&quot;
	 *     StringUtil.abbreviate(&quot;abcdefg&quot;, 4) = &quot;a...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefg&quot;, 3) = IllegalArgumentException
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * @param maxWidth
	 *            ��󳤶ȣ���С�� <code>4</code> �����С�� <code>4</code> ������
	 *            <code>4</code>
	 * 
	 * @return �ַ������ԣ����ԭʼ�ַ���Ϊ <code>null</code> �򷵻� <code>null</code>
	 */
	public static String abbreviate(String str, int maxWidth) {
		return abbreviate(str, 0, maxWidth);
	}

	/**
	 * ���ַ���ת����ָ�����ȵ����ԣ����磺 ��"Now is the time for all good men"ת����"...is the time
	 * for..."��
	 * 
	 * <p>
	 * �� <code>abbreviate(String, int)</code> ���ƣ�����������һ������߽硱ƫ������
	 * ע�⣬����߽硱�����ַ�δ�س����ڽ���ַ���������ߣ���һ�������ڽ���ַ����С�
	 * </p>
	 * 
	 * <p>
	 * ���ص��ַ��������ܳ���ָ���� <code>maxWidth</code>��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.abbreviate(null, *, *)                = null
	 *     StringUtil.abbreviate(&quot;&quot;, 0, 4)                  = &quot;&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, -1, 10) = &quot;abcdefg...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 0, 10)  = &quot;abcdefg...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 1, 10)  = &quot;abcdefg...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 4, 10)  = &quot;abcdefg...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 5, 10)  = &quot;...fghi...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 6, 10)  = &quot;...ghij...&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 8, 10)  = &quot;...ijklmno&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 10, 10) = &quot;...ijklmno&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 12, 10) = &quot;...ijklmno&quot;
	 *     StringUtil.abbreviate(&quot;abcdefghij&quot;, 0, 3)        = IllegalArgumentException
	 *     StringUtil.abbreviate(&quot;abcdefghij&quot;, 5, 6)        = IllegalArgumentException
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * @param offset
	 *            ��߽�ƫ����
	 * @param maxWidth
	 *            ��󳤶ȣ���С�� <code>4</code> �����С�� <code>4</code> ������
	 *            <code>4</code>
	 * 
	 * @return �ַ������ԣ����ԭʼ�ַ���Ϊ <code>null</code> �򷵻� <code>null</code>
	 */
	public static String abbreviate(String str, int offset, int maxWidth) {
		if (str == null) {
			return null;
		}

		// ���������
		if (maxWidth < 4) {
			maxWidth = 4;
		}

		if (str.length() <= maxWidth) {
			return str;
		}

		if (offset > str.length()) {
			offset = str.length();
		}

		if ((str.length() - offset) < (maxWidth - 3)) {
			offset = str.length() - (maxWidth - 3);
		}

		if (offset <= 4) {
			return str.substring(0, maxWidth - 3) + "...";
		}

		// ���������
		if (maxWidth < 7) {
			maxWidth = 7;
		}

		if ((offset + (maxWidth - 3)) < str.length()) {
			return "..." + abbreviate(str.substring(offset), maxWidth - 3);
		}

		return "..." + str.substring(str.length() - (maxWidth - 3));
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �Ƚ������ַ�������ͬ�� */
	/*                                                                              */
	/* �����ַ���֮��Ĳ��죬�Ƚ��ַ��������ƶȡ� */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * �Ƚ������ַ�����ȡ�õڶ����ַ����У��͵�һ���ַ�����ͬ�Ĳ��֡�
	 * 
	 * <pre>
	 * 
	 *     StringUtil.difference(&quot;i am a machine&quot;, &quot;i am a robot&quot;)  = &quot;robot&quot;
	 *     StringUtil.difference(null, null)                        = null
	 *     StringUtil.difference(&quot;&quot;, &quot;&quot;)                            = &quot;&quot;
	 *     StringUtil.difference(&quot;&quot;, null)                          = &quot;&quot;
	 *     StringUtil.difference(&quot;&quot;, &quot;abc&quot;)                         = &quot;abc&quot;
	 *     StringUtil.difference(&quot;abc&quot;, &quot;&quot;)                         = &quot;&quot;
	 *     StringUtil.difference(&quot;abc&quot;, &quot;abc&quot;)                      = &quot;&quot;
	 *     StringUtil.difference(&quot;ab&quot;, &quot;abxyz&quot;)                     = &quot;xyz&quot;
	 *     StringUtil.difference(&quot;abcde&quot;, &quot;abxyz&quot;)                  = &quot;xyz&quot;
	 *     StringUtil.difference(&quot;abcde&quot;, &quot;xyz&quot;)                    = &quot;xyz&quot;
	 * 
	 * </pre>
	 * 
	 * @param str1
	 *            �ַ���1
	 * @param str2
	 *            �ַ���2
	 * 
	 * @return �ڶ����ַ����У��͵�һ���ַ�����ͬ�Ĳ��֡���������ַ�����ͬ���򷵻ؿ��ַ��� <code>""</code>
	 */
	public static String difference(String str1, String str2) {
		if (str1 == null) {
			return str2;
		}

		if (str2 == null) {
			return str1;
		}

		int index = indexOfDifference(str1, str2);

		if (index == -1) {
			return EMPTY_STRING;
		}

		return str2.substring(index);
	}

	/**
	 * �Ƚ������ַ�����ȡ�����ַ�����ʼ��ͬ������ֵ��
	 * 
	 * <pre>
	 * 
	 *     StringUtil.indexOfDifference(&quot;i am a machine&quot;, &quot;i am a robot&quot;)   = 7
	 *     StringUtil.indexOfDifference(null, null)                         = -1
	 *     StringUtil.indexOfDifference(&quot;&quot;, null)                           = -1
	 *     StringUtil.indexOfDifference(&quot;&quot;, &quot;&quot;)                             = -1
	 *     StringUtil.indexOfDifference(&quot;&quot;, &quot;abc&quot;)                          = 0
	 *     StringUtil.indexOfDifference(&quot;abc&quot;, &quot;&quot;)                          = 0
	 *     StringUtil.indexOfDifference(&quot;abc&quot;, &quot;abc&quot;)                       = -1
	 *     StringUtil.indexOfDifference(&quot;ab&quot;, &quot;abxyz&quot;)                      = 2
	 *     StringUtil.indexOfDifference(&quot;abcde&quot;, &quot;abxyz&quot;)                   = 2
	 *     StringUtil.indexOfDifference(&quot;abcde&quot;, &quot;xyz&quot;)                     = 0
	 * 
	 * </pre>
	 * 
	 * @param str1
	 *            �ַ���1
	 * @param str2
	 *            �ַ���2
	 * 
	 * @return ���ַ�����ʼ�������������ֵ��������ַ�����ͬ���򷵻� <code>-1</code>
	 */
	public static int indexOfDifference(String str1, String str2) {
		if ((str1 == str2) || (str1 == null) || (str2 == null)) {
			return -1;
		}

		int i;

		for (i = 0; (i < str1.length()) && (i < str2.length()); ++i) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
		}

		if ((i < str2.length()) || (i < str1.length())) {
			return i;
		}

		return -1;
	}

	/**
	 * ȡ�������ַ��������ƶȣ� <code>0</code> �����ַ�����ȣ�����Խ���ʾ�ַ���Խ����
	 * 
	 * <p>
	 * ����㷨ȡ�� <a
	 * href="http://www.merriampark.com/ld.htm">http://www.merriampark.
	 * com/ld.htm </a>�� ��������Ǵ��ַ���1ת�䵽�ַ���2����Ҫ��ɾ����������滻�Ĳ�������
	 * </p>
	 * 
	 * <pre>
	 * 
	 *     StringUtil.getLevenshteinDistance(null, *)             = IllegalArgumentException
	 *     StringUtil.getLevenshteinDistance(*, null)             = IllegalArgumentException
	 *     StringUtil.getLevenshteinDistance(&quot;&quot;,&quot;&quot;)               = 0
	 *     StringUtil.getLevenshteinDistance(&quot;&quot;,&quot;a&quot;)              = 1
	 *     StringUtil.getLevenshteinDistance(&quot;aaapppp&quot;, &quot;&quot;)       = 7
	 *     StringUtil.getLevenshteinDistance(&quot;frog&quot;, &quot;fog&quot;)       = 1
	 *     StringUtil.getLevenshteinDistance(&quot;fly&quot;, &quot;ant&quot;)        = 3
	 *     StringUtil.getLevenshteinDistance(&quot;elephant&quot;, &quot;hippo&quot;) = 7
	 *     StringUtil.getLevenshteinDistance(&quot;hippo&quot;, &quot;elephant&quot;) = 7
	 *     StringUtil.getLevenshteinDistance(&quot;hippo&quot;, &quot;zzzzzzzz&quot;) = 8
	 *     StringUtil.getLevenshteinDistance(&quot;hello&quot;, &quot;hallo&quot;)    = 1
	 * 
	 * </pre>
	 * 
	 * @param s
	 *            ��һ���ַ���������� <code>null</code> ���������ַ���
	 * @param t
	 *            �ڶ����ַ���������� <code>null</code> ���������ַ���
	 * 
	 * @return ���ƶ�ֵ
	 */
	public static int getLevenshteinDistance(String s, String t) {
		s = defaultIfNull(s);
		t = defaultIfNull(t);

		int[][] d; // matrix
		int n; // length of s
		int m; // length of t
		int i; // iterates through s
		int j; // iterates through t
		char s_i; // ith character of s
		char t_j; // jth character of t
		int cost; // cost

		// Step 1
		n = s.length();
		m = t.length();

		if (n == 0) {
			return m;
		}

		if (m == 0) {
			return n;
		}

		d = new int[n + 1][m + 1];

		// Step 2
		for (i = 0; i <= n; i++) {
			d[i][0] = i;
		}

		for (j = 0; j <= m; j++) {
			d[0][j] = j;
		}

		// Step 3
		for (i = 1; i <= n; i++) {
			s_i = s.charAt(i - 1);

			// Step 4
			for (j = 1; j <= m; j++) {
				t_j = t.charAt(j - 1);

				// Step 5
				if (s_i == t_j) {
					cost = 0;
				} else {
					cost = 1;
				}

				// Step 6
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]
						+ cost);
			}
		}

		// Step 7
		return d[n][m];
	}

	/**
	 * ȡ����С����
	 * 
	 * @param a
	 *            ����1
	 * @param b
	 *            ����2
	 * @param c
	 *            ����3
	 * 
	 * @return �������е���Сֵ
	 */
	private static int min(int a, int b, int c) {
		if (b < a) {
			a = b;
		}

		if (c < a) {
			a = c;
		}

		return a;
	}


	public static String jiequ(String bcatagoryname, String zcatagoryname,
			String scatagoryname, Integer maxlength) {
		String s = bcatagoryname + "\\" + zcatagoryname + "\\" + scatagoryname;
		if (s.length() > maxlength.intValue()) {
			s = s.substring(0, maxlength.intValue()) + "...";
		}
		return s;
	}

	public static Integer sLength(String str) {
		return str.length();
	}

	// ȥ���������Ͽ�*
	public static String countrySub(String str) {
		return str.replace("*", "");
	}

/*	// �����ػ����ϵͳ���ж���Ϊ��Ϊ������Ա���˻������
	public static int sfcy(String tldleaderid, String departleaderid,Long owner,Long trenid,Integer userid) {
		if(trenid!=null && trenid!=0){//����
			if (tldleaderid == null || "".equals(tldleaderid)) {
				tldleaderid = ""+owner+","+trenid;
			}
			if (departleaderid == null || "".equals(departleaderid)) {
				departleaderid = ""+owner+","+trenid;
			}
			if (!"".equals(tldleaderid) && !"".equals(departleaderid)) {
				tldleaderid = tldleaderid + "," + departleaderid+","+owner+","+trenid;
			}
			if ("".equals(tldleaderid) && !"".equals(departleaderid)) {
				tldleaderid = departleaderid+","+owner+","+trenid;
			}
			if (!"".equals(tldleaderid) && "".equals(departleaderid)) {
				tldleaderid = tldleaderid+","+owner+","+trenid;
			}			
		}else{//�Ǵ���
			if (tldleaderid == null || "".equals(tldleaderid)) {
				tldleaderid = ""+owner;
			}
			if (departleaderid == null || "".equals(departleaderid)) {
				departleaderid = ""+owner;
			}
			if (!"".equals(tldleaderid) && !"".equals(departleaderid)) {
				tldleaderid = tldleaderid + "," + departleaderid+","+owner;
			}
			if ("".equals(tldleaderid) && !"".equals(departleaderid)) {
				tldleaderid = departleaderid+","+owner;
			}
			if (!"".equals(tldleaderid) && "".equals(departleaderid)) {
				tldleaderid = tldleaderid+","+owner;
			}			
		}
			
		int flag = 0;
		if (tldleaderid != null && !"".equals(tldleaderid)) {
			if (tldleaderid.indexOf(",") != -1) {
				String id[] = tldleaderid.split(",");
				for (int i = 0; i < id.length; i++) {
					if (Integer.parseInt(id[i]) == userid.intValue()) {
						flag = 1;
						break;
					}
				}
			} else {
				if (Integer.parseInt(tldleaderid) == userid.intValue()) {
					flag = 1;
				}
			}
		}
		return flag;
	}*/

	
	
	// �����ػ����ϵͳ���ж���Ϊ��Ϊ������Ա���˻������
	public static int sfcy(String tldleaderid, String departleaderid,Integer userid) {
	
			if (tldleaderid == null || "".equals(tldleaderid)) {
				tldleaderid = "";
			}
			if (departleaderid == null || "".equals(departleaderid)) {
				departleaderid = "";
			}
			if (!"".equals(tldleaderid) && !"".equals(departleaderid)) {
				tldleaderid = tldleaderid + "," + departleaderid;
			}
			if ("".equals(tldleaderid) && !"".equals(departleaderid)) {
				tldleaderid = departleaderid;
			}
			if (!"".equals(tldleaderid) && "".equals(departleaderid)) {
				tldleaderid = tldleaderid;
			}			
		
			
		int flag = 0;
		if (tldleaderid != null && !"".equals(tldleaderid)) {
			if (tldleaderid.indexOf(",") != -1) {
				String id[] = tldleaderid.split(",");
				for (int i = 0; i < id.length; i++) {
					if (Integer.parseInt(id[i]) == userid.intValue()) {
						flag = 1;
						break;
					}
				}
			} else {
				if (Integer.parseInt(tldleaderid) == userid.intValue()) {
					flag = 1;
				}
			}
		}
		//System.out.println(flag);
		return flag;
	}	
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
//		System.out.println(countrySub("̨��*"));
		// sfcy("1719,337400,1334,211886",1397);
		// System.out.println(sfcy("1719,337400,1334,211886",1719));
	}

}