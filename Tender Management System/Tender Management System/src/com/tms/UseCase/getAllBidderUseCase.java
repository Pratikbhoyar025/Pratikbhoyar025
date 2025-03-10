package com.tms.UseCase;

import java.util.List;
import java.util.Scanner;
import com.tms.bean.BidderBean;
import com.tms.dao.BidderDao;
import com.tms.dao.BidderDaoImpl;


public class getAllBidderUseCase {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tender id: ");
		int tid = sc.nextInt();


		BidderDao dao =new BidderDaoImpl();

		try {
			List<BidderBean> Blist= dao.getAllBidsOfaTender(tid);

			if(Blist.size()==0) {
				System.out.println("No bidding record!!");
			}else {
				Blist.forEach(s->{
					System.out.println("******************************************");
					System.out.println("Bidder id: "+ s.getBidId());
					System.out.println("Bidding Amount: "+ s.getBidAmount());
					System.out.println("Bidding Status: "+ s.getBidStatus());
					System.out.println("vendor Id: "+ s.getVendorId());
					System.out.println("******************************************");
				});
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


}
