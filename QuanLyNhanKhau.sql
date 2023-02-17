

--tạo các bảng

--tao bang user
CREATE TABLE TaiKhoan(
ID INT PRIMARY KEY,
TaiKhoan VARCHAR(20) NOT NULL,
MatKhau VARCHAR(20) NOT NULL
)

-- tao bang nhan khau
CREATE TABLE NhanKhau (
MaNhanKhau VARCHAR(20) NOT NULL PRIMARY KEY,
HoTen NVARCHAR(50) NOT NULL,
CCCD VARCHAR(20) NOT NULL,
NgaySinh DATE ,
GioiTinh NVARCHAR(6),
QueQuan NVARCHAR(200),
ThuongTru NVARCHAR(200),
Dantoc NVARCHAR(20),
NgheNghiep NVARCHAR(50),
)


--tao bang Ho Khau
CREATE TABLE HoKhau(
MaHoKhau VARCHAR(10) PRIMARY KEY,
MaNKChuHo VARCHAR(20) NOT NULL,
Diachi NVARCHAR(200) NOT NULL
)

--tao bang Thanh Vien cuar Ho
CREATE TABLE ThanhVienCuaHo(
MaNhanKhau VARCHAR(20) NOT NULL,
MaHoKhau VARCHAR(10) NOT NULL,
QuanHeVoiCH NVARCHAR(10),
NoiThuongTruTruoc NVARCHAR(200),
MaTrongHoKhau INT NOT NULL,
PRIMARY KEY(MaNhanKhau, MaHoKhau)
)


--tao bang Tam Tru
CREATE TABLE TamTru(
ID VARCHAR(10) PRIMARY KEY,
MaNhanKhau VARCHAR(20) NOT NULL,
NoiTamTru NVARCHAR(200) NOT NULL,
TuNgay DATE,
DenNgay DATE,
LyDo NVARCHAR(100)
)


--tao bang Tam Vang
CREATE TABLE TamVang(
ID VARCHAR(10) PRIMARY KEY,
MaNhanKhau VARCHAR(20) NOT NULL,
NoiTamTru NVARCHAR(200) NOT NULL,
TuNgay DATE,
DenNgay DATE,
LyDo NVARCHAR(100)
)

--tao bang Phan Anh Kien Nghi
CREATE TABLE PhanAnhKienNghi(
MaPA VARCHAR(20) PRIMARY KEY,
MaNhanKhau VARCHAR(20) NOT NULL,
NoiDung NVARCHAR(1000) NOT NULL,
NgayPA DATE NOT NULL,
TrangThai NVARCHAR(30) NOT NULL,
CapPhanHoi NVARCHAR(50),
PhanHoi NVARCHAR(1000),
NgayPhanHoi DATE
)


--tao cac rang buoc
ALTER TABLE dbo.HoKhau
ADD	 FOREIGN KEY (MaNKChuHo) REFERENCES NhanKhau(MaNhanKhau)

ALTER TABLE dbo.TamTru
ADD FOREIGN KEY (MaNhanKhau) REFERENCES dbo.NhanKhau(MaNhanKhau)

ALTER TABLE	dbo.TamVang
ADD FOREIGN KEY (MaNhanKhau) REFERENCES dbo.NhanKhau(MaNhanKhau)

ALTER	TABLE dbo.PhanAnhKienNghi
ADD	FOREIGN KEY (MaNhanKhau) REFERENCES dbo.NhanKhau(MaNhanKhau)

ALTER TABLE dbo.ThanhVienCuaHo
ADD FOREIGN KEY (MaNhanKhau) REFERENCES dbo.NhanKhau(MaNhanKhau)

ALTER TABLE dbo.ThanhVienCuaHo
ADD FOREIGN KEY (MaHoKhau) REFERENCES dbo.HoKhau(MaHoKhau)




INSERT INTO dbo.NhanKhau (MaNhanKhau,HoTen, CCCD, NgaySinh, GioiTinh, QueQuan, ThuongTru, Dantoc, NgheNghiep)
VALUES
('NK.00001', N'Võ Hoài Nam', '0000000001', '2002-04-20', N'Nam', N'Kỳ Thư - Kỳ Anh - Hà Tĩnh', N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00002', N'Trần Thị Minh', '0000000002', '2002-06-01', N'Nữ', N'Xuân Thủy - Thanh Hóa', N'Số 23 Nguyễn Văn Cừ- Long Biên- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00003', N'Nguyễn Văn Tài', '0000000003', '1999-07-10', N'Nam', N'Đông Hồ - Bắc Giang', N'Số 123 Đồng Nhân- Hai Bà Trưng- Hà Nội',N'Kinh', N'Nhân viên văn phòng'),
('NK.00004', N'Lê Thị Hạnh', '0000000004', '2001-09-01', N'Nữ', N'Bắc Hải - Quảng Ninh', N'Số 11 Lý Thái Tổ- Hoàn Kiếm- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00005', N'Đinh Thị Thanh', '0000000005', '1998-12-20', N'Nữ', N'Tràng An - Ninh Bình', N'Số 3 Trần Hưng Đạo- Hoàn Kiếm- Hà Nội',N'Kinh', N'Nhân viên bán hàng'),
('NK.00006', N'Phạm Văn Hiếu', '0000000006', '2000-05-01', N'Nam', N'Yên Dũng - Bắc Giang', N'Số 4 Nguyễn Trãi- Hai Bà Trưng- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00007', N'Nguyễn Thị Tý', '0000000007', '1999-06-10', N'Nữ', N'Cẩm Xuyên - Hà Tĩnh', N'Số 5 Đội Cấn- Ba Đình- Hà Nội',N'Kinh', N'Nhân viên văn phòng'),
('NK.00008', N'Trần Văn Đức', '0000000008', '2002-07-01', N'Nam', N'Yên Thành - Nghệ An', N'Số 6 Ngô Quyền- Hai Bà Trưng- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00009', N'Đặng Thị Linh', '0000000009', '2001-01-05', N'Nữ', N'Hải Hậu - Nam Định', N'Số 7 Trần Hưng Đạo- Hoàn Kiếm- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00010', N'Phan Văn Anh', '0000000010', '1998-08-20', N'Nam', N'Hoàng Su Phì - Hà Giang', N'Số 8 Đội Cấn- Ba Đình- Hà Nội',N'Kinh', N'Nhân viên kỹ thuật'),
('NK.00011', N'Ngô Thị Hải', '0000000011', '2000-03-05', N'Nữ', N'Vĩnh Lộc - Thanh Hóa', N'Số 9 Trần Hưng Đạo- Hoàn Kiếm- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00012', N'Lê Văn Dũng', '0000000012', '1999-12-10', N'Nam', N'Đồng Hỷ - Thái Bình', N'Số 10 Nguyễn Trãi- Hai Bà Trưng- Hà Nội',N'Kinh', N'Nhân viên bán hàng'),
('NK.00013', N'Vũ Thị Nga', '0000000013', '2001-11-05', N'Nữ', N'Yên Thành - Nghệ An', N'Số 11 Lý Thái Tổ- Hoàn Kiếm- Hà Nội',N'Kinh', N'Sinh viên'),
('NK.00014', N'Trần Văn Tài', '0000000014', '1998-07-15', N'Nam', N'Yên Dũng - Bắc Giang', N'Số 12 Nguyễn Văn Cừ- Long Biên- Hà Nội',N'Kinh', N'Nhân viên kỹ thuật'),
('NK.00015', N'Nguyễn Thị Tuyết', '0000000015', '1999-09-10', N'Nữ', N'Cẩm Xuyên - Hà Tĩnh', N'Số 13 Trần Hưng Đạo- Hoàn Kiếm- Hà Nội', N'Kinh', N'Sinh viên'),
('NK.00016', N'Phạm Văn Hoàng', '0000000016', '1997-06-20', N'Nam', N'Lục Nam - Bắc Kạn', N'Số 14 Đội Cấn- Ba Đình- Hà Nội', N'Kinh', N'Nhân viên bán hàng'),
('NK.00017', N'Trần Thị Thanh', '0000000017', '2000-05-15', N'Nữ', N'Nam Trực - Nam Định', N'Số 15 Trần Hưng Đạo- Hoàn Kiếm- Hà Nội', N'Kinh', N'Sinh viên'),
('NK.00018', N'Lê Văn Long', '0000000018', '1999-02-20', N'Nam', N'Yên Dũng - Bắc Giang', N'Số 16 Nguyễn Văn Cừ- Long Biên- Hà Nội', N'Kinh', N'Nhân viên kỹ thuật'),
('NK.00019', N'Đặng Thị Tâm', '0000000019', '2000-04-05', N'Nữ', N'Tứ Kỳ - Thái Bình', N'Số 17 Lý Thái Tổ- Hoàn Kiếm- Hà Nội', N'Kinh', N'Sinh viên'),
('NK.00020', N'Nguyễn Văn Hải', '0000000020', '1997-08-15', N'Nam', N'Hải Hậu - Nam Định', N'Số 18 Đội Cấn- Ba Đình- Hà Nội', N'Kinh', N'Nhân viên bán hàng');

INSERT INTO dbo.HoKhau (MaHoKhau, MaNKChuHo,Diachi) VALUES
('HK.00001','NK.00001', N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00002','NK.00004', N'Số 10 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00003','NK.00006', N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00004','NK.00009', N'Số 10 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội'),
('HK.00005','NK.00014', N'Số 20 Hoàng Hoa Thám- Tây Hồ- Hà Nội'),
('HK.00006','NK.00018', N'Số 30 Hoàng Cầu- Đống Đa- Hà Nội');


INSERT INTO dbo.ThanhVienCuaHo(MaNhanKhau,MaHoKhau,QuanHeVoiCH,NoiThuongTruTruoc, MaTrongHoKhau)VALUES
('NK.00001', 'HK.00001',  N'Chủ hộ',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh', 1),
('NK.00002', 'HK.00001',  N'Vợ',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội', 2),
('NK.00003', 'HK.00001',  N'Con ruột',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội', 3),
('NK.00004', 'HK.00002', N'Chủ hộ',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội', 1),
('NK.00005', 'HK.00002', N'Vợ',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội', 2),
('NK.00006', 'HK.00003', N'Chủ hộ',N'Phạm Hùng- Hai Bà Trưng- Hà Nội', 1),
('NK.00007', 'HK.00003', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội', 2),
('NK.00008', 'HK.00003', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội', 3),
('NK.00009', 'HK.00004', N'Chủ hộ',N'Lê Văn Sỹ- Hai Bà Trưng- Hà Nội', 1),
('NK.00010', 'HK.00004', N'Vợ',N'Lê Văn Sỹ- Hai Bà Trưng- Hà Nội', 2),
('NK.00011', 'HK.00004', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội', 3),
('NK.00012', 'HK.00004', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội', 4),
('NK.00013', 'HK.00004', N'Con ruột',N'Phạm Hùng- Hai Bà Trưng- Hà Nội', 5),
('NK.00014', 'HK.00005', N'Chủ hộ',N'Trần Minh- Hai Bà Trưng- Hà Nội', 1),
('NK.00015', 'HK.00005', N'Vợ',N'Ngô Quốc Đạt- Hai Bà Trưng- Hà Nội', 2),
('NK.00016', 'HK.00005', N'Chủ hộ',N'Phạm Hải Đăng- Hai Bà Trưng- Hà Nội', 3),
('NK.00017', 'HK.00005', N'Con ruột',N'Phạm Hải Đăng- Hai Bà Trưng- Hà Nội', 4),
('NK.00018', 'HK.00006', N'Chủ hộ',N'Ngô Quốc Đạt- Hai Bà Trưng- Hà Nội', 1),
('NK.00019', 'HK.00006', N'Vợ',N'Trần Nhật Tân- Hai Bà Trưng- Hà Nội', 2),
('NK.00020', 'HK.00006', N'Con ruột',N'Trần Nhật Tân- Hai Bà Trưng- Hà Nội', 2);



INSERT INTO dbo.TamTru(ID,MaNhanKhau,NoiTamTru,TuNgay,DenNgay,LyDo)
VALUES
('TT.00001', 'NK.00001',N'Số 2 Tạ Quang Bửu- Hai Bà Trưng- Hà Nội','2020-10-8','2021-10-8', NULL),
('TT.00002', 'NK.00002',N'Số 3 Định Công- Tây Hồ- Hà Nội','2021-1-10','2022-1-10', N'Đi du học'),
('TT.00003', 'NK.00003',N'Số 4 Hàng Bạc- Hoàn Kiếm- Hà Nội','2021-5-15','2022-5-15', N'Công tác'),
('TT.00004', 'NK.00004',N'Số 5 Lê Văn Hưu- Cầu Giấy- Hà Nội','2021-3-20','2021-9-20', N'Khám chữa bệnh'),
('TT.00005', 'NK.00005',N'Số 6 Trần Đại Nghĩa- Hoàng Mai- Hà Nội','2021-7-25','2022-7-25', N'Học tập');


INSERT INTO dbo.TamVang(ID,MaNhanKhau,NoiTamTru,TuNgay,DenNgay,LyDo)
VALUES
('TV.00001', 'NK.00001',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2020-10-8','2021-10-8', NULL),
('TV.00002', 'NK.00002',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2021-12-5','2022-2-8', N'Công tác'),
('TV.00003', 'NK.00002',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2022-5-20','2022-10-30', N'Du lịch'),
('TV.00004', 'NK.00003',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2021-8-15','2021-10-10', N'Học tập'),
('TV.00005', 'NK.00003',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2022-1-5','2022-3-15', N'Học tập'),
('TV.00006', 'NK.00003',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2022-8-1','2022-9-30', N'Học tập'),
('TV.00007', 'NK.00001',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2022-12-1','2023-1-15', N'Du lịch'),
('TV.00008', 'NK.00002',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2023-1-5','2023-2-5', N'Du lịch'),
('TV.00009', 'NK.00003',N'Nguyễn Trãi- Hai Bà Trưng- Hà Nội','2022-9-1','2022-10-30', N'Học tập'),
('TV.00010', 'NK.00001',N'Kỳ Thư - Kỳ Anh - Hà Tĩnh','2022-12-15','2023-1-30', N'Du lịch');

INSERT INTO dbo.PhanAnhKienNghi
(MaPA,MaNhanKhau,NoiDung,NgayPA,TrangThai, CapPhanHoi, PhanHoi,NgayPhanHoi)
VALUES
('PA.00001','NK.00001',N'Phản ánh về an toàn giao thông ở đường TQB',GETDATE(),N'Chưa phản hồi',NULL,NULL, NULL),
('PA.00002','NK.00002',N'Kiến nghị về việc xây dựng công viên',GETDATE(),N'Đã phản hồi',NULL, NULL, NULL),
('PA.00003','NK.00003',N'Phản ánh về chất lượng dịch vụ của công ty điện nước',GETDATE(),N'Chưa phản hồi',NULL,NULL, NULL),
('PA.00004','NK.00004',N'Kiến nghị về việc xây dựng sân chơi cho trẻ em',GETDATE(),N'Đang xử lý',NULL,NULL,NULL),
('PA.00005','NK.00005',N'Phản ánh về tình trạng bẩn chất lộ rộng',GETDATE(),N'Đã phản hồi',NULL,NULL,NULL),
('PA.00006','NK.00006',N'Kiến nghị về việc tổ chức sự kiện văn hóa',GETDATE(),N'Chưa phản hồi',NULL,NULL,NULL),
('PA.00007','NK.00007',N'Phản ánh về tình trạng môi trường',GETDATE(),N'Đang xử lý',NULL,NULL,NULL);


INSERT INTO dbo.TaiKhoan
(ID,TaiKhoan,MatKhau)
VALUES
( 1,'Nam','123'),
( 2,'1','1'),
( 3,'','')
