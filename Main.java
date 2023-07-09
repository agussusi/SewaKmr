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
		  System.out.println("================================");
		}
	
	
//	Menginisialisasi  Menu Menu Ke Dalam ArrayList
	public static void initKamar() {
		
		Kamar kamar1 = new Kamar("Mawar", 150000);
		Kamar kamar2 = new Kamar("Melati", 100000);
		Kamar kamar3 = new Kamar("Anggrek", 75000);

		Member member1 = new createMember("1", "Silo");

		Member member2 = new createMember("2", "Ngurah");
	
		Member member3 = new createMember("3", "Wisnu");

		//tambah ke dalam arraylist		
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
	
//	Show Kamar
public static void showRoom() {
	System.out.println("=============== DAFTAR KAMAR  ===============");
	System.out.println("Id" + "\tNama" + "\t\tHarga");
	int i = 0;
    for (Kamar kamar : edit.kamars) {
		i++;
        System.out.println((i) + "\t" + kamar.getName() + "\t\t" + kamar.getPrice());
    }
}

// Show Member
public static void showMembers() {
    for (Member member : edit.members) {
        System.out.println(member.id + " " + member.name);
    }
}

// Tambah Member
public static void addMember() {
	System.out.print("id: ");
	String memberId = scan.next();

	System.out.print("name: ");
	String memberName = scan.next();

	Member member = new createMember(memberId, memberName);
	edit.addMember(member);
}

//	method Delete Member
	public static void deleteMember(){
		System.out.println("Anda Memilih Pilihan Delete Menu");
		
		 boolean ValidId = false;
		    
		// Perulangan Untuk Melakukan Input Nomor Menu Jika Inputan User Lebih
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

	
//	method tambah 
	public static void addRoom() {
		System.out.println("Anda memilih pilihan add room");
		
		// membuat hashset dengan nama variabel val		
		 HashSet<String> val = new HashSet<String>();
		 //memasukan elemen elemen array ke dalam variabel val		 
		 for(Kamar kamar : edit.kamars) {
				val.add(kamar.getName());
			}
		
		System.out.print("Masukan Nama Kamar : ");
		scan.nextLine();
		String name = scan.nextLine();
		
		//mencocokan apakah variabel namaMakanan sudah ada pada arraylist dengan perulangan		
		while(val.contains(name)) {
			System.out.println("\nNama Kamar Sudah Ada");
			System.out.print("Masukan Nama Kamar : ");
			name = scan.nextLine();
		}
		
		String nama = name;
		
		
		System.out.print("Masukan Harga Kamar : ");
		
		// Validasi Jika User Menginput Huruf pada inputan harga (Dengan fungsi hasNextInt())   	
    	while(!scan.hasNextInt()) {
    		 System.out.print("Masukan Harga Kamar : ");
    	     scan.next();
    	}
    	
		int price = scan.nextInt();
	   	

		// mengirim inputan ke method Kamar dengan object beserta parameternya		
		Kamar tambahan = new Kamar(name, price);
		// Memanggil Method tambahMenu pada Class Crud		
		edit.addRoom(tambahan);
		
	}
	
//	method Update
	public static void updateKamar() {
	    System.out.println("Anda memilih pilihan update menu");
	    
	    	
	    boolean ValidId = false;
	    
	    // perulangan untuk pengecekan input user
	    while(!ValidId) {
	    	
	    	System.out.println("Masukan Id Kamar Yang Akan di Ubah : ");
	    	
	    	try {
	    		// Validasi Jika User Menginput Huruf Pada Inputan Memasukan id kamar	    	
	    		while(!scan.hasNextInt()) {
	    			System.out.println("Masukan Id Kamar Yang Akan di Ubah : ");
	    			scan.next();
	    		}
	    		
	    		int id = scan.nextInt();
	    		
	    		// pengecekan id yang diinput	    		
	    		if (id < 1 || id > edit.kamars.size()) {
	    			//Jika inputan User Lebih, Maka Akan Melempar Pesan Ke Catch	    			
	    			throw new Exception("Id Kamar Tidak Tersedia");
	    		}
	    		
	    		//mengubah ValidId agar perulangan tidak berkerja		    		
	    		ValidId = true;
	    		
	    		System.out.print("Masukan Nama Kamar yang Baru : ");
	    		scan.nextLine();
	    		String name = scan.nextLine();
	    		
	    		// Jika Inputan Nama Kamar Kosong, maka Data Yang Sebelumnnya Tetap Ada 	        
	    		if (name.isEmpty()) {
	    			name = edit.kamars.get(id-1).getName();
	    		}
	    		
	    		System.out.print("Masukan Harga Kamar yang Baru : ");
	    		String hargaKamar = scan.nextLine();
	    		
	    		// Jika Inputan Harga Kosong, maka Data Yang Sebelumnnya Tetap Ada dan akan diubah menjadi data tipe String	
	    		if (hargaKamar.isEmpty()) {
	    			hargaKamar = Integer.toString(edit.kamars.get(id-1).getPrice());
	    		}else {	    			
	    			boolean isValid = false;
	    			
	    			// perulangan dengan kondisi tidak sama dengan isValid (jika isValid true maka perulangan selesai)	        	
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
	    		
				Kamar ubah = new Kamar(name, harga);
				edit.updateKamar(id, ubah);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public static void checkinRoom() {
		System.out.print("id member : ");
		String memberId = scan.next();
	
		
		System.out.print("room name: ");
		String name = scan.next();
	
		edit.giveKamar( memberId,name);
	}
	
	public static void checkoutRoom() {
		System.out.print("id member : ");
		String memberId = scan.next();
	  
		
		System.out.print("room name : ");
		String name = scan.next();
	  
		edit.receiveKamar( memberId,name);
	  }

	}
	
	