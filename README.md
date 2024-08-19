# HW-6

<h2>پرسش‌ها</h2>

<h3>پرسش اول</h3>

- دسته‌ی اول Creational Patterns هستند. این الگوها روی ساخته شدن اشیا تمرکز می‌کنند. هدف آن است که با مدیریت نحوه‌ی ایجاد و ترکیب شدن اشیا از ایجاد اشیاء غیرضروری و یا وقوع پیچیدگی‌ها جلوگیری شود. همچنین مهم است که ساخت اشیا و کلیت سامانه از یکدیگر مستقل باشند.
- دسته‌ی دوم structural Patterns هستند. این الگوها روی ارتبط‌ها و ترکیب شدن‌های کلاس‌های گوناگون تمرکز می‌کنند. هدف آن است که ساختارهای بزرگ‌تر به نحوی ایجاد شوند که با اعمال تغییرات کوچک در بخش‌های کوچک‌ترشان، کلیت عملکرد سامانه تغییر نکند.
- دسته‌ی سوم Behavioral Patterns هستند. این الگوها تعامل‌های میان اشیاء را مدیریت می‌کنند تا رفتار آن‌ها در موقعیت‌های گوناگون بهینه شود. تقسیم مسئولیت‌ها میان اشیاء گوناگون و پرتعداد و همچنین مدیریت جریان کنترل در سامانه‌های پیچیده از مسئولیت‌های این الگوهاست.

<h3>پرسش دوم</h3>

الگوهای State و Strategy هر دو مربوط به الگوهای Behavioral هستند. در الگوی استراتژی از میان روش‌های گوناگون برای انجام یک کار به شکل پویا و مستقل از کاربر یکی انتخاب می‌شود. این موضوع نشان‌دهنده‌ی مدیریت جریان کنترل و همچنین توزیع مسئولیت‌ها میان اشیاء است که مربوط به الگوهای رفتاری می‌شود. در الگوی استیت رفتار یک شیء بر اساس وضعیت داخلی آن در موقعیت‌های مختلف تغییر می‌کند. مشخصا این الگو هم با رفتار اشیاء درگیر است و مربوط به الگوهای رفتاری می‌شود.

<h3>پرسش سوم</h3>

<p>در این سناریو تمامی یال‌های بین شهری یا در حالت یک‌طرفه قرار داشتند یا دوطرفه. بنابراین انگار برای شهر ما دو **State** (جهت‌دار، بی‌جهت) وجود داشت و براساس اینکه در کدام State هستیم، نحوه  `toggleDirection` متفاوتی برای پیاده‌سازی داشتیم. بنابراین از آنجا که شامل تعدادی State بودیم که هر یک دارای رفتار متفاوتی برای پیاده‌سازی این تابع بود، به سراغ الگوی طراحی **State** رفتیم. بنابراین یک اینترفیس `State` تعریف کردیم که دو متد `toggleDirection(Graph graph)` و `nextState()` را پیاده‌سازی کرده بود و سپس دو کلاس `UnidirectionalState` و `BidirectionalState` را با ارث‌بری از این اینترفیس پیاده‌سازی کردیم. بنابراین یک فیلد `state` در کلاس اصلی ما وجود خواهد داشت و برای پیاده‌سازی `toggleDirection` در این کلاس، دو خط `state.toggleDirection(graph)` و سپس `state = state.nextState()` اجرا می‌شوند.</p>

<h3>پرسش چهارم</h3>

<h3>پرسش پنجم</h3>

<h3>پرسش ششم</h3>

<h3>پرسش هفتم</h3>

<h3>پرسش هشتم</h3>

<h3>پرسش نهم</h3>
