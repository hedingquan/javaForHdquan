package com.hdquan;

public class SingleTon {
	//���ڶ�����Ҫ����̬�������ã��ѷ�������Ϊstatic
	//���ڶ�����static������Ҫ���÷���Ȩ�����η�Ϊprivate�������public����ֱ�ӵ��ö��󣬲�ִ�з������
	private static SingleTon singleTon;
	private SingleTon()//�����಻��ʵ������������
	{
		
	}
	//������Ҫ�����ṩ�������
	//ʵ��������ʵ����������ͨ��������ã����ǹ��캯���Ѿ�˽�л��ˣ���������޷�ȡ��
	//���÷���Ϊ��̬����

	public static SingleTon getInstance()
	{
		//����߼����ʵ��������ֱ�ӷ���
		if(singleTon==null)
		{
			//���̷߳����£����ܳ���ifͬʱ����������������
			synchronized(SingleTon.class)
			{
				//˫����֤
				if(singleTon==null)
				{
					singleTon=new SingleTon();
				}
			}
		}
		return singleTon;
	}
}
