package com.phy.redis;

public class EirlessBackgroundApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final EirlessBackgroundApp eirlessBackgroundApp = new EirlessBackgroundApp();
		Thread msgServer = new Thread(eirlessBackgroundApp.new MessageServer());
		Thread containerTrackingServer = new Thread(
				eirlessBackgroundApp.new ContainerTrackingServer());
		Thread eirlessServer = new Thread(
				eirlessBackgroundApp.new EirlessServer());
		Thread rollbackBillServer = new Thread(
				eirlessBackgroundApp.new RollbackBillServer());
		Thread sendMsgToPortServer = new Thread(
				eirlessBackgroundApp.new SendMsgToPortServer());

		msgServer.start();
		containerTrackingServer.start();
		eirlessServer.start();
		rollbackBillServer.start();
		sendMsgToPortServer.start();

	}

	/**
	 * 推送消息线程
	 * 
	 * @author jack_liu
	 * 
	 */
	class MessageServer implements Runnable {
		private RedisClient redisClient = new RedisClient();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				redisClient.sendMsg("MessageServer", "1");
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 轨迹跟踪线程
	 * 
	 * @author jack_liu
	 * 
	 */
	class ContainerTrackingServer implements Runnable {
		private RedisClient redisClient = new RedisClient();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				redisClient.sendMsg("ContainerTrackingServer", "1");
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 无纸化线程
	 * 
	 * @author jack_liu
	 * 
	 */
	class EirlessServer implements Runnable {
		private RedisClient redisClient = new RedisClient();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				redisClient.sendMsg("EirlessServer", "1");
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 回滚单线程
	 * 
	 * @author jack_liu
	 * 
	 */
	class RollbackBillServer implements Runnable {
		private RedisClient redisClient = new RedisClient();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				redisClient.sendMsg("RollbackBillServer", "1");
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * 往码头发送消息线程
	 * 
	 * @author jack_liu
	 * 
	 */
	class SendMsgToPortServer implements Runnable {
		private RedisClient redisClient = new RedisClient();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				redisClient.sendMsg("SendMsgToPortServer", "1");
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
