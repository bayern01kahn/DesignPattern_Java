package proxy.staticProxy.extendsWay;

public class FootballPlayer implements IRequestSalaryOffer {

	@Override
	public void priceOffer() {
		System.out.println("提出工资要求");
	}
}
