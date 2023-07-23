import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static Crud edit = new Crud();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initKamar();;
		String isContinue = "y";

		while (isContinue.equals("y")) {
			showMenu();
			int selectedMenu = chooseMenu();
	  
			if (selectedMenu == 1) {
			  showRoom();
			} else if (selectedMenu == 2) {
			  showMembers();
			} else if (selectedMenu == 3) {
			  addRoom();
			} else if (selectedMenu == 4) {
			  addMember();
			} else if (selectedMenu == 5) {
			  deleteMember();
			} else if (selectedMenu == 6) {
			  updateKamar();
			} else if (selectedMenu == 7) {
			  checkinRoom();
			} else if (selectedMenu == 8) {
			  checkoutRoom();
			} else if (selectedMenu == 9) {
				tetsObject();
			} else {
				System.out.println("wrong input");
			}
	  
			System.out.print("continue ? (y/n) ");
			isContinue = scan.next();
		  }
		}
	  
	public static void showMenu() {
		System.out.println("================================");
		System.out.println("1. show list kamar");
		System.out.println("2. show member");
		System.out.println("3. add kamar");
		System.out.println("4. add member");
		System.out.println("5. delete member");
		System.out.println("6. update kamar");
		System.out.println("7. checkin kamar");
		System.out.println("8. checkout kamar");
		System.out.println("9. Test Object");
		System.out.println("================================");
	}
	
	public static void initKamar() {
		Kamar kamar1 = new Kamar( "1", "Mawar",150000);
		Kamar kamar2 = new Kamar("2", "Kamboja", 100000);
		Kamar kamar3 = new Kamar("3", "Anggrek", 750000);

		Member member1 = new createMember("1", "Silo");
		Member member2 = new createMember("2", "Ngurah");
		Member member3 = new createMember("3", "Wisnu");
		 
		edit.kamars.add(kamar1);
		edit.kamars.add(kamar2);
		edit.kamars.add(kamar3);

		edit.members.add(member1);
		edit.members.add(member2);
		edit.members.add(member3);
	}
	
	public static int chooseMenu() {
		System.out.print("choose menu : ");
		int pilihan = scan.nextInt();
		return pilihan;
	}
	
	public static void showRoom() {
	System.out.println("=============== DAFTAR KAMAR  ===============");
	System.out.println("Id" + "\tNama" + "\t\tHarga");

		for (Kamar kamar : edit.kamars) {
			System.out.println(kamar.getId() + "\t" + kamar.getName() + "\t\t" + kamar.getPrice());
		}
	}

	public static void showMembers() {
		for (Member member : edit.members) {
			System.out.println(member.id + " " + member.name);
		}
	}

	public static void addMember() {
		System.out.print("id: ");
		String memberId = scan.next();

		System.out.print("name: ");
		String memberName = scan.next();

		Member member = new createMember(memberId, memberName);
		edit.addMember(member);
	}

	public static void deleteMember(){
		System.out.println("Anda Memilih Pilihan Delete Menu");
		 boolean ValidId = false;

		 while(!ValidId) {
			 System.out.println("Masukkan Id Member yang Akan dihapus : ");
			 
			 try {
				 
				 while(!scan.hasNextInt()) {
					 System.out.println("\nInput harus berupa angka!");
					 System.out.print("Masukkan Id Member yang Akan dihapus : ");
					 scan.next();
				 }
				 
				 int id = scan.nextInt();
				 
				 if (id < 1 || id > edit.members.size()) {
		    		//Jika inputan User Lebih, Maka Akan Melempar Pesan Ke Catch	    			
		    		throw new Exception("Id Kamar Tidak Tersedia");
				 }
		    		
				 // Jika Inputan Nomor Sudah Benar Maka While Yang Sebelumnya Berhenti	    		
				 ValidId = true;
				 
				 System.out.println("Apakah Anda Ingin Menghapus Kamar " +edit.members.get(id-1).id + " Dari list Kamar? (y/n)");
					 
				 while (!scan.hasNext("[yn]")) {
				 }
				 
				String validasi = scan.next();
					
				if(validasi.equals("y") ) {			
					edit.deleteMember(id);
				}
				 
			 }catch(Exception e) {
				 System.out.println("Id Kamar Tidak Tersedia");
			 }	
		 }
	}

	public static void addRoom() {
		System.out.println("Anda memilih pilihan add room");
		HashSet<String> val = new HashSet<String>();
	
		for (Kamar kamar : edit.kamars) {
			val.add(kamar.getName());
		}
	
		System.out.print("Masukan ID Kamar: ");
		scan.nextLine(); 
		String id = scan.nextLine();

		System.out.print("Masukan Nama Kamar: ");
		String name = scan.nextLine();
	
		while (val.contains(name)) {
			System.out.println("\nNama Kamar Sudah Ada");
			System.out.print("Masukan Nama Kamar : ");
			name = scan.nextLine();
		}
	
		System.out.print("Masukan Harga Kamar: ");
		while (!scan.hasNextInt()) {
			System.out.print("Masukan Harga Kamar: ");
			scan.next();
		}
	
		int price = scan.nextInt();
		Kamar tambahan = new Kamar(id,name,price);
		edit.addRoom(tambahan);
	}

	public static void updateKamar() {
	    System.out.println("Anda memilih pilihan update menu");
	    boolean ValidId = false;
	    
	    while(!ValidId) {
	    	System.out.print("Masukan Id Kamar Yang Akan di Ubah : ");
	    	
	    	try {
	    		while(!scan.hasNextInt()) {
	    			System.out.println("Masukan Id Kamar Yang Akan di Ubah : ");
	    			scan.next();
	    		}
	    		
	    		int id = scan.nextInt();
	    			    		
	    		if (id < 1 || id > edit.kamars.size()) {	    			
	    			throw new Exception("Id Kamar Tidak Tersedia");
	    		}
	    			    		
	    		ValidId = true;

				System.out.print("Masukan ID Kamar: ");
				scan.nextLine(); 
	    		
	    		System.out.print("Masukan Nama Kamar yang Baru : ");
	    		scan.nextLine();
	    		String name = scan.nextLine();
	    			        
	    		if (name.isEmpty()) {
	    			name = edit.kamars.get(id-1).getName();
	    		}
	    		
	    		System.out.print("Masukan Harga Kamar yang Baru : ");
	    		String hargaKamar = scan.nextLine();
	    		
	    		if (hargaKamar.isEmpty()) {
	    			hargaKamar = Integer.toString(edit.kamars.get(id-1).getPrice());
	    		}else {	    			
	    			boolean isValid = false;        	
	    			while(!isValid) {
	    				try {
	    					Integer.parseInt(hargaKamar);
	    					isValid = true;
	    				} catch (NumberFormatException e) {
	    					System.out.print("Masukan Harga Kamar yang Baru : ");
	    					hargaKamar = scan.nextLine();
	    				}
	    			}
	    		}   	

	    		int harga = Integer.parseInt(hargaKamar);
	    		
				Kamar ubah = new Kamar(harga, name);
				edit.updateKamar(id, ubah);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	public static void checkinRoom() {
		System.out.print("id member : ");
		String memberId = scan.next();
	
		System.out.print("room name: ");
		String name = scan.next();
	
		edit.giveKamar(memberId,name);
	}
	
	public static void checkoutRoom() {
		System.out.print("id member : ");
		String memberId = scan.next();
	  
		System.out.print("room name : ");
		String name = scan.next();
	  
		edit.receiveKamar( memberId,name);
	}

	public static void tetsObject(){
		Kamar room1 = new Kamar("1");
		Kamar room2 = new Kamar("2","Pacar",150000);
		Kamar room3 = new Kamar(150000, "Kembang Sepatu");

		System.out.println(room1.getId());
		System.out.println(room2.getName() + "\t" + room2.getPrice());
		System.out.println(room3.getPrice() + "\t" + room3.getName());
	}
}

	
	