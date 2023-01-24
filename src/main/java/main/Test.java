package main;

import com.groupeisi.securiteweb.dto.CompteDto;
import com.groupeisi.securiteweb.service.CompteDtoImpl;
import com.groupeisi.securiteweb.service.ICompteDto;

public class Test {
    public static void main(String[] args) {

		CompteDto appComptDto = new CompteDto();
		appComptDto.setUsername("Moussa");
		appComptDto.setPassword("passer1234");
		ICompteDto udao = new CompteDtoImpl();
		int result = udao.add(appComptDto);
		System.out.println(result);

		/*DroitDto appRoleDto = new  DroitDto();
		appRoleDto.setNom("Mouss");
    IDroitDto rdao = new DroitDtoImpl();
    int result = rdao.add(appRoleDto);
		System.out.println(result);
		rdao.list().stream()
				.forEach(r->System.out.println("ID : " + r.getId() + " , Nom : " + r.getNom()));

		System.out.println(new DroitImpl().getByNom("USER").getId());*/

}
}
