package com.yoyling.utils.jwglxt;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZFsoft {
	private final String LOGIN_URL="http://jw.xmut.edu.cn/jwglxt/xtgl/login_slogin.html?language=zh_CN&_t=";
	private final String PUBLICKEY_URL="http://jw.xmut.edu.cn/jwglxt/xtgl/login_getPublicKey.html?time=";
	private final String CHECK_SCORE_URL="http://jw.xmut.edu.cn/jwglxt/cjcx/cjcx_cxDgXscj.html?doType=query&gnmkdm=N305005";
	private final String STUDENT_INFORMATION_URL="http://jw.xmut.edu.cn/jwglxt/cjcx/cjcx_cxDgXscj.html?doType=query&gnmkdm=N100801";

	private CloseableHttpClient httpClient;
	private BasicCookieStore basicCookieStore;
	public ZFsoft(){
		basicCookieStore=new BasicCookieStore();
		httpClient= HttpClients
				.custom()
				.setDefaultCookieStore(basicCookieStore)
				.build();
	}

	/**
	 * 密码加密 RSA
	 * @param password
	 * @return
	 */
	private String encryp(String password){
		//一、获取 exponent modulus 生成公钥
		String exponent=null,modulus=null;
		HttpGet gpkHttpGet=
				new HttpGet(PUBLICKEY_URL+new Date().getTime());
		gpkHttpGet.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
		gpkHttpGet.setHeader("Accept-Encoding","gzip, deflate");
		gpkHttpGet.setHeader("Accept-Language","zh-CN,zh;q=0.9");
		gpkHttpGet.setHeader("Connection","keep-alive");
		gpkHttpGet.setHeader("Host","jw.xmut.edu.cn");
		gpkHttpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		gpkHttpGet.setHeader("X-Requested-With","XMLHttpRequest");
		CloseableHttpResponse gpkResponse=null;
		try {
			gpkResponse = httpClient.execute(gpkHttpGet);
			if (gpkResponse.getStatusLine().getStatusCode() == 200) {
				String emJson = EntityUtils.toString(gpkResponse.getEntity(), "utf8");
				JSONObject jsonObject = new JSONObject(emJson);
				exponent = jsonObject.getString("exponent");
				modulus = jsonObject.getString("modulus");
			}
		}catch (Exception e){
			System.out.println("连接异常");
			e.printStackTrace();
		}finally {
			try {
				gpkResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//二、根据公钥进行密码加密
		password=RSAEncoder.RSAEncrypt(password,B64.b64tohex(modulus),B64.b64tohex(exponent));
		password=B64.hex2b64(password);
		return password;
	}

	/**
	 * 获取Token
	 * @param timestamp
	 * @return
	 */
	private String crawlCsrfToken(String timestamp){
		String csrftoken=null;
		HttpGet csrftokenHttpGet=
				new HttpGet(LOGIN_URL+timestamp);
		CloseableHttpResponse csrftokenResponse=null;
		try {
			csrftokenResponse = httpClient.execute(csrftokenHttpGet);
			if (csrftokenResponse.getStatusLine().getStatusCode() == 200) {
				Document csrftokenDoc = Jsoup.parse(EntityUtils.toString(csrftokenResponse.getEntity(), "utf8"));
				csrftoken = csrftokenDoc
						.select(".col-sm-4")
						.select(".sl_log_rt")
						.select("input[id=csrftoken]")
						.first()
						.attr("value");
				return csrftoken;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				csrftokenResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 模拟登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public ZFsoft login(String username,String password){
		String timestamp=""+new Date().getTime();
		HttpPost loginHttpPost=new HttpPost(LOGIN_URL+timestamp);
		loginHttpPost.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
		loginHttpPost.setHeader("Accept-Encoding","gzip, deflate");
		loginHttpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");
		loginHttpPost.setHeader("Cache-Control","max-age=0");
		loginHttpPost.setHeader("Connection","keep-alive");
		loginHttpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
		loginHttpPost.setHeader("Host","jw.xmut.edu.cn");
		loginHttpPost.setHeader("Origin","http://jw.xmut.edu.cn");
		loginHttpPost.setHeader("Upgrade-Insecure-Requests","1");
		loginHttpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		List<NameValuePair> loginParams=new ArrayList<NameValuePair>();
		password=this.encryp(password);
		String csrftoken=this.crawlCsrfToken(timestamp);
		loginParams.add(new BasicNameValuePair("csrftoken",csrftoken));
		loginParams.add(new BasicNameValuePair("yhm",username));
		loginParams.add(new BasicNameValuePair("mm",password));
		loginParams.add(new BasicNameValuePair("mm",password));
		CloseableHttpResponse loginResponse=null;
		try {
			loginHttpPost.setEntity(new UrlEncodedFormEntity(loginParams, "utf8"));
			loginResponse = httpClient.execute(loginHttpPost);
			List<Cookie>cookies=basicCookieStore.getCookies();
			if(cookies.isEmpty()){
				System.out.println("The Cookie Is None.");
			}else {
				for(Cookie cookie:cookies){

				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * 查看成绩
	 * @param xnm 年份比如2018
	 * @param xqm 学期比如1
	 * @return
	 */
	public List<Score> checkScore(String xnm,String xqm){
		HttpPost scoreHttpPost=new HttpPost(CHECK_SCORE_URL);
		scoreHttpPost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
		scoreHttpPost.setHeader("Accept-Encoding","gzip, deflate");
		scoreHttpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");
		scoreHttpPost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		scoreHttpPost.setHeader("Host","jw.xmut.edu.cn");
		scoreHttpPost.setHeader("Origin","http://jw.xmut.edu.cn");
		scoreHttpPost.setHeader("Proxy-Connection","keep-alive");
		scoreHttpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		scoreHttpPost.setHeader("X-Requested-With","XMLHttpRequest");
		List<NameValuePair>scoreParams=new ArrayList<NameValuePair>();
		scoreParams.add(new BasicNameValuePair("xnm",xnm));
		scoreParams.add(new BasicNameValuePair("xqm",xqm));
		scoreParams.add(new BasicNameValuePair("_search","false"));
		scoreParams.add(new BasicNameValuePair("nd",""+new Date().getTime()));
		scoreParams.add(new BasicNameValuePair("queryModel.showCount","100"));
		scoreParams.add(new BasicNameValuePair("queryModel.currentPage","1"));
		scoreParams.add(new BasicNameValuePair("queryModel.sortName",""));
		scoreParams.add(new BasicNameValuePair("queryModel.sortOrder","asc"));
		scoreParams.add(new BasicNameValuePair("time","1"));
		try {
			scoreHttpPost.setEntity(new UrlEncodedFormEntity(scoreParams, "utf8"));
			CloseableHttpResponse scoreResponse = httpClient.execute(scoreHttpPost);
			if (scoreResponse.getStatusLine().getStatusCode() == 200) {
				if (scoreResponse.getEntity() != null) {
					String scoreJson = EntityUtils.toString(scoreResponse.getEntity(), "utf8");

					System.out.println("scoreJson:"+scoreJson);

					JSONObject jsonObject = new JSONObject(scoreJson);

					System.out.println("jsonObject:"+jsonObject);

					JSONArray jsonArray = jsonObject.getJSONArray("items");

//					System.out.println(jsonArray);

					List<Score>scoreList=new ArrayList<Score>();
					for (int i = 0; i < jsonArray.length(); ++i) {
						JSONObject item = (JSONObject) jsonArray.get(i);
						Score score=new Score();
						score.setXh(item.getString("xh"));
						score.setXm(item.getString("xm"));
						score.setKcmc(item.getString("kcmc"));
						score.setBj(item.getString("bj"));
						score.setCj(item.getString("cj"));
						score.setXf(item.getString("xf"));
						String jd = "0";
						try {
							jd = item.getString("jd");
						} catch (Exception e) {
							e.printStackTrace();
						}
						score.setJd(jd);
						score.setJgmc(item.getString("jgmc"));
						score.setKch(item.getString("kch"));
						score.setKcxzmc(item.getString("kcxzmc"));
						score.setKsxz(item.getString("ksxz"));
						scoreList.add(score);
					}
					return  scoreList;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
