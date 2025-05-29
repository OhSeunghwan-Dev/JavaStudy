package view;

import view.admin.ProductManagementPage;
import view.member.LoginPage;
import view.member.MemberInfoPage;
import view.member.MemberListPage;
import view.member.RechargePage;
import view.member.SigninPage;
import view.member.SignoutPage;
import view.product.AddProductPage;
import view.product.BuyListPage;
import view.product.DeleteProductPage;
import view.product.ProductListPage;
import view.product.SaveListPage;

public class Template {
	
	private SigninPage signinPage = new SigninPage();
	private LoginPage loginPage = new LoginPage();
	private SignoutPage signoutPage = new SignoutPage();
	private RechargePage rechargePage = new RechargePage();
	private MemberInfoPage memberInfoPage = new MemberInfoPage();
	private ProductListPage productListPage = new ProductListPage();
	private BuyListPage	buyListPage = new BuyListPage();
	private SaveListPage saveListPage = new SaveListPage();
	private MemberListPage memberListPage = new MemberListPage();
	private AddProductPage addProductPage = new AddProductPage();
	private DeleteProductPage deleteProductPage = new DeleteProductPage();
	
	
	public SigninPage getSigninPage() {
		return signinPage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public SignoutPage getSignoutPage() {
		return signoutPage;
	}
	
	public RechargePage getRechargePage() {
		return rechargePage;
	}
	
	public MemberInfoPage getMemberInfoPage() {
		return memberInfoPage;
	}
	
	public ProductListPage getProductListPage() {
		return productListPage;
	}

	public BuyListPage getBuyListPage() {
		return buyListPage;
	}
	
	public SaveListPage getSaveListPage() {
		return saveListPage;
	}
	
	public MemberListPage getMemberListPage() {
		return memberListPage;
	}

	public AddProductPage getAddProductPage() {
		return addProductPage;
	}

	public DeleteProductPage getDeleteProductPage() {
		return deleteProductPage;
	}
}
