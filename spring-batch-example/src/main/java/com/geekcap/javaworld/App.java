package com.geekcap.javaworld;

public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
    	
    	final Resources resources = new Resources();
    	Runnable run = new Runnable(){
    		@Override
    		public void run() {
    			try {
    				resources.getNum();
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    		}
    	};
    	for(int i=0;i<10;i++){
    		new Thread(run).start();
    	}
    	resources.getNum();
    	
    }
    
}
class Resources{
	
	public int getNum() throws InterruptedException{
		
		int num = 0;
		num++;
		System.out.println("当前线程是:"+Thread.currentThread().getName());
		Thread.sleep(1000);
		System.out.println(num);
		return num;
		
	}
	
}
