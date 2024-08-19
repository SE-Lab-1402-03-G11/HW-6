# HW-6

<h2>پرسش‌ها</h2>

<h3>پرسش اول</h3>

- دسته‌ی اول Creational Patterns هستند. این الگوها روی ساخته شدن اشیا تمرکز می‌کنند. هدف آن است که با مدیریت نحوه‌ی ایجاد و ترکیب شدن اشیا از ایجاد اشیاء غیرضروری و یا وقوع پیچیدگی‌ها جلوگیری شود. همچنین مهم است که ساخت اشیا و کلیت سامانه از یکدیگر مستقل باشند.
- دسته‌ی دوم structural Patterns هستند. این الگوها روی ارتبط‌ها و ترکیب شدن‌های کلاس‌های گوناگون تمرکز می‌کنند. هدف آن است که ساختارهای بزرگ‌تر به نحوی ایجاد شوند که با اعمال تغییرات کوچک در بخش‌های کوچک‌ترشان، کلیت عملکرد سامانه تغییر نکند.
- دسته‌ی سوم Behavioral Patterns هستند. این الگوها تعامل‌های میان اشیاء را مدیریت می‌کنند تا رفتار آن‌ها در موقعیت‌های گوناگون بهینه شود. تقسیم مسئولیت‌ها میان اشیاء گوناگون و پرتعداد و همچنین مدیریت جریان کنترل در سامانه‌های پیچیده از مسئولیت‌های این الگوهاست.

<h3>پرسش دوم</h3>

<p>الگوهای State و Strategy هر دو مربوط به الگوهای Behavioral هستند. در الگوی استراتژی از میان روش‌های گوناگون برای انجام یک کار به شکل پویا و مستقل از کاربر یکی انتخاب می‌شود. این موضوع نشان‌دهنده‌ی مدیریت جریان کنترل و همچنین توزیع مسئولیت‌ها میان اشیاء است که مربوط به الگوهای رفتاری می‌شود. در الگوی استیت رفتار یک شیء بر اساس وضعیت داخلی آن در موقعیت‌های مختلف تغییر می‌کند. مشخصا این الگو هم با رفتار اشیاء درگیر است و مربوط به الگوهای رفتاری می‌شود.</p>

<h3>پرسش سوم</h3>

در این سناریو تمامی یال‌های بین شهری یا در حالت یک‌طرفه قرار داشتند یا دوطرفه. بنابراین انگار برای شهر ما دو **State** (جهت‌دار، بی‌جهت) وجود داشت و براساس اینکه در کدام State هستیم، نحوه  `toggleDirection` متفاوتی برای پیاده‌سازی داشتیم. بنابراین از آنجا که شامل تعدادی State بودیم که هر یک دارای رفتار متفاوتی برای پیاده‌سازی این تابع بود، به سراغ الگوی طراحی **State** رفتیم. بنابراین یک اینترفیس `State` تعریف کردیم که دو متد `toggleDirection(Graph graph)` و `nextState()` را پیاده‌سازی کرده بود و سپس دو کلاس `UnidirectionalState` و `BidirectionalState` را با ارث‌بری از این اینترفیس پیاده‌سازی کردیم. بنابراین یک فیلد `state` در کلاس اصلی ما وجود خواهد داشت و برای پیاده‌سازی `toggleDirection` در این کلاس، دو خط `state.toggleDirection(graph)` و سپس `state = state.nextState()` اجرا می‌شوند.

<h3>پرسش چهارم</h3>

- اصل SRP: معمولا این الگو مانع از تحقق این اصل می‌شود. البته دقت کنید که این موضوع قطعی نیست. برای توضیح بیش‌تر توجه کنید که رفتار بر اساس این الگو باعث می‌شود که معمولا یک کلاس علاوه بر وظیفه‌ی مدیریت کردن ایجاد نمونه‌ها وظایف دیگری مثل مدیریت منطق و ... را هم بر عهده بگیرد.
- اصل OCP: توسعه دادن یک کلاسی که با الگوی سینگلتون ساخته شده‌است، معمولا کار ساده‌ای نیست. پس وقوع این اصل زیر سوال قرار می‌گیرد. اگر لازم باشد به یک کلاس سینگلتون یک رفتار جدید اضافه کنیم، معمولا لازم می‌شود تغییرات در آن اعمال کنیم که این اصل را نقض می‌کند.
-  اصل LSP: یک کلاس با الگوی سینگلتون ممکن است این اصل را نقض کند. اگر رفتار یک کلاس با الگوی سینگلتون به پیاده‌سازی آن وابستگی زیادی داشته‌باشد، ممکن است وقوع این اصل به خطر بیفتد.
- اصل ISP: این اصل از نظر تئوری با کلاس‌های سینگلتون سازگار است. یعنی در حالت کلی می‌توان گفت که وقوعش با چالش مواجه نمی‌شود. در حالتی که یک واسط بیش از حد بزرگ توسط این کلاس پیاده‌سازی شود امکان وقوع اصل زیر سوال می‌رود.
- اصل DIP: یک کلاس مطابق با الگوی سینگلتون می‌تواند اصل DIP را نقض کند، زیرا در بیش‌تر اوقات به کلاس‌های خاصی وابسته می‌شود. یعنی به جای این که به انتزاع‌ها تکیه کند، به کلاس‌ها وابسته می‌شود و اصل را به حاشیه می‌برد.. از آن جا که Singleton مدیریت ایجاد نمونه‌ی خود را بر عهده دارد و ممکن است از تزریق وابستگی‌ها پشتیبانی نکند، این مسئله می‌تواند جایگزینی یا مثلا ساختن وابستگی‌ها برای آزمون را سخت‌تر کند.

<h3>پرسش پنجم</h3>

- کد تمیز کدی است که به راحتی قابل خواندن، فهمیدن، نگهداری، و همچنین توسعه باشد. همجنین لازم است از اصول و شیوه‌های بهینه‌ای که برنامه‌نویسی وجود دارند هم پیروی کند.
- گاهی اوقات به دلیل برخی از تصمیمات ناپایداری که به هنگام توسعه‌ی یک محصول گرفته می‌شوند، هزینه‌های اضافه‌ای به محصول تحمیل می‌شود که برای عملکرد بهتر سامانه لازم است در آینده ویرایش شوند. به این موارد اصطلاحا بدهی فنی می‌گویند.
- گاهی اوقات کد یک سامانه در ظاهر مناسب است اما نشانه‌هایی  در کد هستند که حاکی از مشکلات یا نقص‌های پنهان در طراحی هستند و ممکن است در آینده نیاز به بازنگری و بهبود داشته باشند. به این نشانه‌ها اصطلاحا بوی بد گفته می‌شود.

<h3>پرسش ششم</h3>

<h3>پرسش هفتم</h3>

<h3>پرسش هشتم</h3>

<h3>پرسش نهم</h3>
