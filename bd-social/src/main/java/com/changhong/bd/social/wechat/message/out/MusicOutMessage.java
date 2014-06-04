package com.changhong.bd.social.wechat.message.out;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 
 */
public class MusicOutMessage extends BaseOutMessage {
	private static final long serialVersionUID = -5376504320854385698L;
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}