/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trumptweetparody;

/**
 *
 * @author Zarathustra aka Kevin aka Konnoke
 */
public class Tweet {
  

  int width, height, likes, replies, retweet, type;
  String text, date;
  final int bigWidth = 640;
  final int bigHeight = 275;
  final int normalWidth = 600;
  final int normalHeight = 135;

  public void setNormalTweet() {
    width = normalWidth;
    height = normalHeight;
    type = 0;
  }

  public void setBigTweet() {
    width = bigWidth;
    height = bigHeight;
    type = 1;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public void setReplies(int replies) {
    this.replies = replies;
  }

  public void setRetweet(int retweet) {
    this.retweet = retweet;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getLikes() {
    return likes;
  }

  public int getReplies() {
    return replies;
  }

  public int getRetweet() {
    return retweet;
  }

  public String getText() {
    return text;
  }

  public String getDate() {
    return date;
  }
  
  public int getType(){
    return type;
  }

}
