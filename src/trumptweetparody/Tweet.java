/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trumptweetparody;

import java.text.DecimalFormat;

/**
 *
 * @author Zarathustra aka Kevin aka Konnoke
 */
public class Tweet {
  

  int width, height, likes, replies, retweet, type;
  String text, date, stringLikes, stringReply, stringRetweet;
  final int bigWidth = 640;
  final int bigHeight = 575;
  final int normalWidth = 600;
  final int normalHeight = 135;

  
  public void setNormalTweet() {
    width = normalWidth;
    height = normalHeight;
    type = 0;
  }
  //Big tweet has been changed to picture tweet
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
  
  public void setStringLike(){
    this.stringLikes = formatNumberExample(likes);
  }
  
  public void setStringReply(){
    this.stringReply = formatNumberExample(replies);
  }
  
  public void setStringRetweet(){
    this.stringRetweet = formatNumberExample(retweet);
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
  
  public String getStringLike(){
    return stringLikes;
  }
  
  public String getStringReply(){
    return stringReply;
  }
  
  public String getStringRetweet(){
    return stringRetweet;
  }
  
  
  //Function where it shortens the int. Example: 32,212 to 32.2k
  public String formatNumberExample(Number number) {
    char[] suffix = {' ', 'k', 'M', 'B', 'T', 'P', 'E'};
    Double numValue = number.doubleValue();
    int value = (int) Math.floor(Math.log10(numValue));
    int base = value / 3;
    if (value >= 3 && base < suffix.length) {
      return new DecimalFormat("#0.0").format(numValue / Math.pow(10, base * 3)) + suffix[base];
    } else {
      return new DecimalFormat("#,##0").format(numValue);
    }
  }
  

}
