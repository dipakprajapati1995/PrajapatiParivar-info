package com.example.prajapatiparivar.retrofit;

import com.example.prajapatiparivar.model.MemberinfoModel;
import com.example.prajapatiparivar.response.ResponseAddUser;
import com.example.prajapatiparivar.response.ResponseAllMemberInfo;
import com.example.prajapatiparivar.response.ResponseAllFamiliInfo;
import com.example.prajapatiparivar.response.ResponseBusiness;
import com.example.prajapatiparivar.response.ResponseFamilyInfo;
import com.example.prajapatiparivar.response.ResponseForgotNumber;
import com.example.prajapatiparivar.response.ResponseLogin;
import com.example.prajapatiparivar.response.ResponseNews;
import com.example.prajapatiparivar.response.ResponseUpDateProfile;
import com.example.prajapatiparivar.response.ResponseUpdatePass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2/26/2018.
 */

public interface ApiInterface {

    @GET("login_api.php")
    Call<ResponseLogin> getlogin(@Query("mobile") String mobile, @Query("password") String passwprd);

    @GET("Forget_numbar.php")
    Call<ResponseForgotNumber> getForgot(@Query("numbar_forget") String Number);

    @GET("UpdatePass.php")
    Call<ResponseUpdatePass> getUpdatePass(@Query("PassUpdate") String Password, @Query("number") String Number);

    @FormUrlEncoded
    @POST("addUserdata.php")
    Call<ResponseAddUser> getAddUser(@Field("image") String Img,
                                     @Field("main_member_number") String main_member_number,
                                     @Field("famile_id") String famile_id,
                                     @Field("name") String name,
                                     @Field("relation") String relation,
                                     @Field("meridas_status") CharSequence meridas_status,
                                     @Field("bod") String bod,
                                     @Field("study") String study,
                                     @Field("mossad") String mossad,
                                     @Field("sasri") String sasri,
                                     @Field("blood_group") String blood_group,
                                     @Field("pyramid_address") String pyramid_address,
                                     @Field("mobile_login") String mobile_login);

    @GET("MemberDetel.php")
    Call<ResponseFamilyInfo> getMemberDetel(@Query("main_member_number") String main_member_number, @Query("famile_id") String famile_id);

    @GET("MemberFullDetail.php")
    Call<MemberinfoModel> getMemberinfo(@Query("main_member_number") String main_member_number);

    @FormUrlEncoded
    @POST("updateProfile.php")
    Call<ResponseUpDateProfile> getUpdateUserProfile(@Field("image") String Img,
                                                     @Field("main_member_number") String main_member_number,
                                                     @Field("famile_id") String famile_id,
                                                     @Field("name") String name,
                                                     @Field("relation") String relation,
                                                     @Field("meridas_status") CharSequence meridas_status,
                                                     @Field("bod") String bod,
                                                     @Field("study") String study,
                                                     @Field("mossad") String mossad,
                                                     @Field("sasri") String sasri,
                                                     @Field("blood_group") String blood_group,
                                                     @Field("pyramid_address") String pyramid_address,
                                                     @Field("mobile_login") String mobile_login,
                                                     @Field("mid") String mid);

    @GET("allMemberDetail.php")
    Call<ResponseAllMemberInfo> getAllMemberDetel();


    @GET("Member.php")
    Call<ResponseAllFamiliInfo> getuserInfi(@Query("main_member_number") String main_member_number);

    @GET("NewsApi.php")
    Call<ResponseNews> getNews();

    @GET("businessApi.php")
    Call<ResponseBusiness> getBusiness();


/*

    @GET("users/register")
    Call<RegistesonResponse> getRagisteson(@Query("fname") String fName,
                                           @Query("lname") String lMame,
                                           @Query("mobile_no") String mobileNo,
                                           @Query("email") String email,
                                           @Query("password") String password);


    @GET("users/updateProfile")
    Call<UserProfileResponse> getUserId(@Query("userId") String UserId,
                                        @Query("first_name") String fName,
                                        @Query("last_name") String lMame,
                                        @Query("birth_date") String BirthDate,
                                        @Query("email") String email,
                                        @Query("address") String Address, @Query("pincode") String Pincode);

    @GET("users/userLogin")
    Call<LoginResponse> GetLogin(@Query("mobile_no") String mobileNo, @Query("password") String password);

    @GET("users/requestOtp")
    Call<OtpResponse> getOtp(@Query("mobile_no") String mobileNo);


    @GET("users/matchOtp")
    Call<OtpVerification> getOtpVarify(@Query("mobile_no") String mobileNo, @Query("otp") String otp);


    @GET("users/updatePassword")
    Call<PasswordForgetResponse> getForegetePassword(@Query("userId") String UserId, @Query("old_password") String Old_Password, @Query("new_password") String new_password);

    @GET("users/userAboutUs")
    Call<ProfileUsResponse> getAboutAs();  // (@Url String About);


    @GET("users/userContactUs")
    Call<ContactUsResponse> getContactUs();

    @GET("users/userPrivacyPolicy")
    Call<UserPrivacyPolicyResponse> getUserPrivacyPolicy();


    @GET("users/myTrips")
    Call<MyTripsResponse> getMyTrips(@Query("userId") String UserId);

    @GET("users/forgotPasswordOtp")
    Call<ForgotOtpPassResponse> getForPassOtp(@Query("mobile_no") String mobileNo);

    @GET("users/forgotPasswordMatchOtp")
    Call<ForgotOtpResponse> getOtpForPassVarify(@Query("mobile_no") String mobileNo, @Query("otp") String otp);

    @GET("users/updateNewPasswod")
    Call<ForgotChengPassResponse> getChengePassword(@Query("mobile_no") String mobileNo, @Query("password") String password);

    @GET("users/userProfile")
    Call<UserProfileUpdateResponse> getUpDateProfile(@Query("userId") String id);


    @GET("users/getTripRate")
    Call<GetTripRateResponse> getTripRate();

    @GET("users/addTrip")
    Call<CreateTripResponse> AddTrip(@Query("userId") String userId,
                                     @Query("trip_start_date") String trip_start_date,
                                     @Query("trip_start_time") String trip_start_time,
                                     @Query("trip_type_id") String trip_type_id,
                                     @Query("trip_pickup_point_lat") Double trip_pickup_point_lat,
                                     @Query("trip_pickup_point_lang") Double trip_pickup_point_lang,
                                     @Query("trip_pickup_point_address") String trip_pickup_point_address,
                                     @Query("trip_pickup_point_city_name") String trip_pickup_point_city_name,
                                     @Query("trip_drop_point_lat") Double trip_drop_point_lat,
                                     @Query("trip_drop_point_lang") Double trip_drop_point_lang,
                                     @Query("trip_drop_point_address") String trip_drop_point_address,
                                     @Query("trip_drop_point_city_name") String trip_drop_point_city_name,
                                     @Query("trip_ast_usage") String trip_ast_usage);

*/

}
