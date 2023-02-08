
--tạo các bảng

--tao bang user
CREATE TABLE TaiKhoan(
ID INT PRIMARY KEY,
TaiKhoan VARCHAR(20) NOT NULL,
MatKhau VARCHAR(20) NOT NULL
)

-- tao bang nhan khau
CREATE TABLE NhanKhau (
HoTen NVARCHAR(50) NOT NULL,
CCCD VARCHAR(20) PRIMARY KEY,
NgaySinh DATE ,
GioiTinh NVARCHAR(6),
QueQuan NVARCHAR(200),
ThuongTru NVARCHAR(200),
NgheNghiep NVARCHAR(50),
IDtrongHK INT
)

--tao bang Ho Khau
CREATE TABLE HoKhau(
IDHoKhau VARCHAR(10) PRIMARY KEY,
CCCDChuho VARCHAR(20) NOT NULL,
Diachi NVARCHAR(200) NOT NULL
)

--tao bang Thanh Vien cuar Ho
CREATE TABLE ThanhVienCuaHo(
CCCD VARCHAR(20) NOT NULL,
IDHoKhau VARCHAR(10) NOT NULL,
QuanHeVoiCH NVARCHAR(10),
NoiThuongTruTruoc NVARCHAR(200),
PRIMARY KEY(CCCD, IDHoKhau)
)


--tao bang Tam Tru
CREATE TABLE TamTru(
ID VARCHAR(10) PRIMARY KEY,
CCCD VARCHAR(20) NOT NULL,
NoiTamTru NVARCHAR(200) NOT NULL,
TuNgay DATE,
DenNgay DATE,
LyDo NVARCHAR(100)
)


--tao bang Tam Vang
CREATE TABLE TamVang(
ID VARCHAR(10) PRIMARY KEY,
CCCD VARCHAR(20) NOT NULL,
NoiTamTru NVARCHAR(200) NOT NULL,
TuNgay DATE,
DenNgay DATE,
LyDo NVARCHAR(100)
)

--tao bang Phan Anh Kien Nghi
CREATE TABLE PhanAnhKienNghi(
maPA VARCHAR(20) PRIMARY KEY,
CCCD VARCHAR(20) NOT NULL,
NoiDung NVARCHAR(1000) NOT NULL,
NgayPA DATE NOT NULL,
CapPhanHoi NVARCHAR(50),
PhanHoi NVARCHAR(1000),
NgayPhanHoi DATE
)


--tao cac rang buoc
ALTER TABLE dbo.HoKhau
ADD	 FOREIGN KEY (CCCDChuho) REFERENCES dbo.NhanKhau(CCCD)

ALTER TABLE dbo.TamTru
ADD FOREIGN KEY (CCCD) REFERENCES dbo.NhanKhau(CCCD)

ALTER TABLE	dbo.TamVang
ADD FOREIGN KEY (CCCD) REFERENCES dbo.NhanKhau(CCCD)

ALTER	TABLE dbo.PhanAnhKienNghi
ADD	FOREIGN KEY (CCCD) REFERENCES dbo.NhanKhau(CCCD)

ALTER TABLE dbo.ThanhVienCuaHo
ADD FOREIGN KEY (CCCD) REFERENCES dbo.NhanKhau(CCCD)

ALTER TABLE dbo.ThanhVienCuaHo
ADD FOREIGN KEY (IDHoKhau) REFERENCES dbo.HoKhau(IDHoKhau)





INSERT INTO dbo.NhanKhau (HoTen, CCCD, NgaySinh, GioiTinh, QueQuan, ThuongTru, NgheNghiep, IDtrongHK)
VALUES
( N'Võ Hoài Nam', '0000000001', '2002-04-20', 'Nam', N'Kỳ Thư - Kỳ Anh - Hà Tĩnh', N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội', 'Sinh viên', NULL),
( N'Trần Thị Tùng Vân', '0000000002', '2000-05-12', 'Nữ', N'Văn Chấn - Yên Bái', N'Số 3 Lê Đức Thọ- Tây Hồ- Hà Nội', 'Học sinh', NULL),
( N'Nguyễn Đình Trọng', '0000000003', '1998-08-08', 'Nam', N'Bắc Giang', N'Số 4 Nguyễn Văn Cừ- Long Biên- Hà Nội', 'Nhân viên văn phòng', NULL),
( N'Phạm Thị Hồng', '0000000004', '1999-06-06', 'Nữ', N'Sơn La', N'Số 5 Đặng Văn Ngữ- Cầu Giấy- Hà Nội', 'Giáo viên', NULL),
( N'Nguyễn Văn A', '0000000005', '1997-12-01', 'Nam', N'Thái Nguyên', N'Số 6 Trần Phú- Đống Đa- Hà Nội', 'Kỹ sư', NULL),
( N'Trần Thị B', '0000000006', '2001-01-15', 'Nữ', N'Hà Nội', N'Số 7 Hoàng Hoa Thám- Tây Hồ- Hà Nội', 'Sinh viên', NULL),
( N'Nguyễn C', '0000000007', '1999-03-20', 'Nam', N'Bắc Ninh', N'Số 8 Đặng Văn Ngữ- Cầu Giấy- Hà Nội', 'Nhân viên kinh doanh', NULL),
( N'Đỗ Thị D', '0000000008', '2000-07-10', 'Nữ', N'Hải Dương', N'Số 9 Trần Phú- Đống Đa- Hà Nội', 'Học sinh', NULL),
( N'Nguyễn E', '0000000009', '1998-02-22', 'Nam', N'Ninh Bình', N'Số 10 Hoàng Hoa Thám- Tây Hồ- Hà Nội', 'Nhân viên văn phòng', NULL),
( N'Trần F', '0000000010', '2002-05-01', 'Nữ', N'Hà Nam', N'Số 11 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội', 'Sinh viên', NULL),
( N'Nguyễn G', '0000000011', '1999-09-05', 'Nam', N'Hải Phòng', N'Số 12 Lê Đức Thọ- Tây Hồ- Hà Nội', 'Kỹ sư', NULL),
( N'Đỗ H', '0000000012', '1997-11-11', 'Nữ', N'Thái Bình', N'Số 13 Đặng Văn Ngữ- Cầu Giấy- Hà Nội', 'Giáo viên', NULL),
( N'Nguyễn I', '0000000013', '2001-06-06', 'Nam', N'Nam Định', N'Số 14 Trần Phú- Đống Đa- Hà Nội', 'Nhân viên kinh doanh', NULL),
( N'Trần J', '0000000014', '1998-12-12', 'Nữ', N'Hà Tĩnh', N'Số 15 Hoàng Hoa Thám- Tây Hồ- Hà Nội', 'Học sinh', NULL),
( N'Nguyễn K', '0000000015', '2000-04-04', 'Nam', N'Quảng Ninh', N'Số 16 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội', 'Nhân viên văn phòng', NULL),
( N'Đỗ L', '0000000016', '1999-02-02', 'Nữ', N'Thanh Hóa', N'Số 17 Lê Đức Thọ- Tây Hồ- Hà Nội', 'Kỹ sư', NULL),
( N'Nguyễn M', '0000000017', '1997-08-08', 'Nam', N'Nghệ An', N'Số 18 Đặng Văn Ngữ- Cầu Giấy- Hà Nội', 'Giáo viên', NULL),
( N'Trần N', '0000000018', '2001-01-01', 'Nữ', N'Hà Tĩnh', N'Số 19 Hoàng Hoa Thám- Tây Hồ- Hà Nội', 'Học sinh', NULL),
( N'Nguyễn O', '0000000019', '1998-03-03', 'Nam', N'Thừa Thiên Huế', N'Số 20 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội', 'Nhân viên kinh doanh', NULL);



INSERT INTO dbo.HoKhau (IDHoKhau, CCCDChuho,Diachi) VALUES
('HK.00001','0000000001', N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00002','0000000004', N'Số 10 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00003','0000000006', N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00004','0000000009', N'Số 10 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00005','0000000014', N'Số 20 Hoàng Hoa Thám- Tây Hồ- Hà Nội'),
('HK.00006','0000000018', N'Số 30 Hoàng Cầu- Đống Đa- Hà Nội');


INSERT INTO dbo.ThanhVienCuaHo(CCCD,IDHoKhau,QuanHeVoiCH,NoiThuongTruTruoc)VALUES
('0000000001', 'HK.00001',  N'Chủ hộ',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh'),
('0000000002', 'HK.00001',  N'Vợ',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội'),
('0000000003', 'HK.00001',  N'Con ruột',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội'),
('0000000004', 'HK.00002', N'Chủ hộ',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội'),
('0000000005', 'HK.00002', N'Vợ',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội'),
('0000000006', 'HK.00003', N'Chủ hộ',N'Phạm Hùng- Hai Bà Trưng- Hà Nội'),
('0000000007', 'HK.00003', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội'),
('0000000008', 'HK.00003', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội'),
('0000000009', 'HK.00004', N'Chủ hộ',N'Lê Văn Sỹ- Hai Bà Trưng- Hà Nội'),
('0000000010', 'HK.00004', N'Vợ',N'Lê Văn Sỹ- Hai Bà Trưng- Hà Nội'),
('0000000011', 'HK.00004', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội'),
('0000000012', 'HK.00004', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội'),
('0000000013', 'HK.00004', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội'),
('0000000014', 'HK.00005', N'Chủ hộ',N'Trần Minh- Hai Bà Trưng- Hà Nội'),
('0000000015', 'HK.00005', N'Vợ',N'Ngô Quốc Đạt- Hai Bà Trưng- Hà Nội'),
('0000000016', 'HK.00005', N'Chủ hộ',N'Phạm Hải Đăng- Hai Bà Trưng- Hà Nội'),
('0000000017', 'HK.00005', N'Con ruột',N'Phạm Hải Đăng- Hai Bà Trưng- Hà Nội'),
('0000000018', 'HK.00006', N'Chủ hộ',N'Ngô Quốc Đạt- Hai Bà Trưng- Hà Nội'),
('0000000019', 'HK.00006', N'Vợ',N'Trần Nhật Tân- Hai Bà Trưng- Hà Nội');



INSERT INTO dbo.TamTru(ID,CCCD,NoiTamTru,TuNgay,DenNgay,LyDo)
VALUES
('TT.00001', '0000000001',N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội','2020-10-8','2021-10-8', NULL),
('TT.00002', '0000000002',N'Số 3 Định Công- Tây Hồ- Hà Nội','2021-1-10','2022-1-10', N'Đi du học'),
('TT.00003', '0000000003',N'Số 4 Hàng Bạc- Hoàn Kiếm- Hà Nội','2021-5-15','2022-5-15', N'Công tác'),
('TT.00004', '0000000004',N'Số 5 Lê Văn Hưu- Cầu Giấy- Hà Nội','2021-3-20','2021-9-20', N'Khám chữa bệnh'),
('TT.00005', '0000000005',N'Số 6 Trần Đại Nghĩa- Hoàng Mai- Hà Nội','2021-7-25','2022-7-25', N'Học tập');


INSERT INTO dbo.TamVang(ID,CCCD,NoiTamTru,TuNgay,DenNgay,LyDo)
VALUES
('TV.00001', '0000000001',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2020-10-8','2021-10-8', NULL),
('TV.00002', '0000000002',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2021-12-5','2022-2-8', N'Công tác'),
('TV.00003', '0000000002',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2022-5-20','2022-10-30', N'Du lịch'),
('TV.00004', '0000000003',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2021-8-15','2021-10-10', N'Học tập'),
('TV.00005', '0000000003',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2022-1-5','2022-3-15', N'Học tập'),
('TV.00006', '0000000003',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2022-8-1','2022-9-30', N'Học tập'),
('TV.00007', '0000000001',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2022-12-1','2023-1-15', N'Du lịch'),
('TV.00008', '0000000002',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2023-1-5','2023-2-5', N'Du lịch'),
('TV.00009', '0000000003',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2022-9-1','2022-10-30', N'Học tập'),
('TV.00010', '0000000001',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2022-12-15','2023-1-30', N'Du lịch');

INSERT INTO dbo.PhanAnhKienNghi (maPA,CCCD,NoiDung,NgayPA,CapPhanHoi,PhanHoi,NgayPhanHoi)
VALUES
( 'PA.00001','0000000001',N'Phản ánh về an toàn giao thông ở đường TQB',GETDATE(),NULL,NULL, NULL),
('PA.00002','0000000002',N'Kiến nghị về việc xây dựng công viên',GETDATE(),NULL,NULL, NULL),
('PA.00003','0000000001',N'Phản ánh về chất lượng dịch vụ của bệnh viện',GETDATE(),NULL,NULL, NULL),
('PA.00004','0000000002',N'Kiến nghị về việc sửa đổi chính sách của trường học',GETDATE(),NULL,NULL, NULL),
('PA.00005','0000000001',N'Phản ánh về tình trạng môi trường',GETDATE(),NULL,NULL, NULL)



